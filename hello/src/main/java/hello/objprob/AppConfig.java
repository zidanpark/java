package hello.objprob;

import hello.objprob.charge.*;
import hello.objprob.member.*;
import hello.objprob.pattern.ChargePolicyFactory;
import hello.objprob.pattern.ClassFactory;
import hello.objprob.pattern.PaymentClassFactory;
import hello.objprob.pattern.PolicyFactory;
import hello.objprob.payment.PaymentClass;
import hello.objprob.payment.PaymentService;
import hello.objprob.payment.PaymentServiceImpl;

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

    public PaymentService paymentService(String type) {
        return new PaymentServiceImpl(memberRepository(), paymentClass(type));
    }

    public PaymentClass paymentClass(String type) {

        ClassFactory classFactory = new PaymentClassFactory();
        return classFactory.createClass(type);
    }
}
