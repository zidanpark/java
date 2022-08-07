package hello.objprob;

import hello.objprob.charge.*;
import hello.objprob.member.*;
import hello.objprob.pattern.ChargePolicyFactory;
import hello.objprob.pattern.PolicyFactory;

public class AppConfig {

    public MemberService memberService () {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public ChargeService chargeService(String type) {
        return new ChargeServiceImpl(memberRepository(), chargePolicy(type));
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public ChargePolicy chargePolicy(String type) {
        /**
         *
        if(type == "FlatRate") {
            return new FlatRateChargePolicy();
        } else if (type == "Voice") {
            return new VoiceChargePolicy();
        }
        // Default
        return new VoiceChargePolicy();
         */
        PolicyFactory policyFactory = new ChargePolicyFactory();
        return policyFactory.createPolicy(type);
    }
}
