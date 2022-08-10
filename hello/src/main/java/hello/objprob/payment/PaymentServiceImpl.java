package hello.objprob.payment;

import hello.objprob.charge.ChargeCheck;
import hello.objprob.member.Member;
import hello.objprob.payment.PaymentClass;
import hello.objprob.member.MemberRepository;

import java.util.Scanner;

public class PaymentServiceImpl implements PaymentService {
    private final MemberRepository memberRepository;
    private final PaymentClass paymentClass;
    private final ChargeCheck chargeCheck;


    public PaymentServiceImpl(MemberRepository memberRepository, PaymentClass paymentClass, ChargeCheck chargeCheck) {
        this.memberRepository = memberRepository;
        this.paymentClass = paymentClass;
        this.chargeCheck = chargeCheck;
    }


    @Override
    public Payment executePayment(Long memberId, int paymentAmt, String paymentType) throws Exception {
        System.out.println("결제 진행됩니다.");
        Member member = memberRepository.findById(memberId);
        if(!chargeCheck.isChargeCheck(member,paymentAmt)) throw new Exception("충전 불가능한 요금제");
        String paymentClassType = paymentClass.selectPayType(paymentClass.getPayType());
        return new Payment(memberId, paymentAmt, paymentType, paymentClassType);
    }

}
