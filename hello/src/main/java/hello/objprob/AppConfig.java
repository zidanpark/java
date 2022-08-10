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
        return new ChargeServiceImpl(memberRepository(), chargeCheck(type));
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public ChargePolicy chargePolicy(String type) {
        PolicyFactory policyFactory = new ChargePolicyFactory();
        return policyFactory.createPolicy(type);
    }

    public ChargeCheck chargeCheck(String type) {
        if(type == "FlatRate") {
            return new FlatRateChargePolicy();
        } else if (type == "Voice") {
            return new VoiceChargePolicy();
        }
        // Default
        return new VoiceChargePolicy();
    }


    public PaymentService paymentService(String paymentType, String chargeType) {
        return new PaymentServiceImpl(memberRepository(), paymentClass(paymentType), chargeCheck(chargeType));
    }

    public PaymentClass paymentClass(String type) {
        ClassFactory classFactory = new PaymentClassFactory();
        return classFactory.createClass(type);
    }
}
