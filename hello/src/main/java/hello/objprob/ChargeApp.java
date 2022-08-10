package hello.objprob;

import hello.objprob.charge.Charge;
import hello.objprob.charge.ChargeService;
import hello.objprob.member.Member;
import hello.objprob.member.MemberService;
import hello.objprob.member.PlanType;
import hello.objprob.payment.Payment;
import hello.objprob.payment.PaymentService;

/**
 * @Desc 충전 로직
 * @Wants 결제 로직 & H2 DB로 변경
 */

public class ChargeApp {

    public static void main(String[] args) throws Exception {
        // 금액 선택 가능하게?
        // 계좌? 신용카드 선택 가능하게?
        // 계좌 및 카드 종류 선택 가능하게?
        try {
            int ticketAmt = 1000;
            String payType = "Account";
            // DI 구현 클래스에 변경 없이 조립가능.
            AppConfig appConfig = new AppConfig();
            MemberService memberService = appConfig.memberService();
            ChargeService chargeService = appConfig.chargeService("Voice");
            PaymentService paymentService = appConfig.paymentService(payType);
            Payment payment = null;
            Charge charge = null;

            Member member = new Member(1L, "memberA", PlanType.Prepaid, 9999);
            memberService.join(member);

            Member findMember = memberService.findMember(1L);

            payment = paymentService.executePayment(findMember.getId(), ticketAmt, payType);
            System.out.println("결제 내역 : " + payment);

            charge = chargeService.createCharge(findMember.getId(), "ticketA", ticketAmt, findMember.getBalanceAmt());
            System.out.println("충전 내역 : "+ charge);
            System.out.println("잔액 : " + charge.getBalanceAmt());

            // 충전 가능 여부 체크
            /**
             * 충전 체크를 컨트롤러에서?
            if (chargeService.isCharge(findMember, ticketAmt)) {
                payment = paymentService.executePayment(findMember.getId(), ticketAmt, payType);
                System.out.println(payment);
            }

            if (!payment.isPaymentStatus()) {
                System.out.println("결제에 실패하셨습니다.");
                return;
            }

             System.out.println(charge);
             System.out.println("잔액 : " + charge.getBalanceAmt());
            */


        } catch ( Exception e ) {

        } finally {
            System.out.println("충전 로직이 종료되었습니다.");
        }
    }
}
