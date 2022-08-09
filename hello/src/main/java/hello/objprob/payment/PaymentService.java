package hello.objprob.payment;

import hello.objprob.member.Member;

public interface PaymentService {
    Payment executePayment(Long memberId, int paymentAmt, String paymentType);
}
