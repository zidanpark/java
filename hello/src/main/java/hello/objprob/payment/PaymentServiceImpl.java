package hello.objprob.payment;

import hello.objprob.member.Member;
import hello.objprob.payment.PaymentClass;
import hello.objprob.member.MemberRepository;

import java.util.Scanner;

public class PaymentServiceImpl implements PaymentService{
    private final MemberRepository memberRepository;
    private final PaymentClass paymentClass;

    public PaymentServiceImpl(MemberRepository memberRepository, PaymentClass paymentClass) {
        this.memberRepository = memberRepository;
        this.paymentClass = paymentClass;
    }


    @Override
    public Payment executePayment(Long memberId, int paymentAmt, String paymentType) {
        System.out.println("결제 진행됩니다.");
        paymentClass.payModuleCall();
        String paymentClassType = paymentClass.selectPayType();

        return new Payment(memberId, paymentAmt, paymentType, paymentClassType, true);
    }

}
