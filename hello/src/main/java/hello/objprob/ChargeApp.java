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
            int ticketAmt = 36300;
            String chargeType = "FlatRate";
            String paymentType = "Card";
            // DI 구현 클래스에 변경 없이 조립가능.
            AppConfig appConfig = new AppConfig();
            final MemberService memberService = appConfig.memberService();
            final ChargeService chargeService = appConfig.chargeService(chargeType);
            final PaymentService paymentService = appConfig.paymentService(paymentType, chargeType);

            Member member = new Member(1L, "memberA", PlanType.FlatRate, 9999);
            memberService.join(member);

            // 회원 검색.
            Member findMember = memberService.findMember(1L);

            Payment payment = paymentService.executePayment(findMember.getId(), ticketAmt, paymentType);
            System.out.println("결제 내역 : "+ payment);

            Charge charge = chargeService.createCharge(findMember.getId(), "ticketA", ticketAmt, findMember.getBalanceAmt());
            System.out.println("충전 내역 : "+ charge);
            System.out.println("잔액 : " + charge.getBalanceAmt());

        } catch ( Exception e ) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("충전 로직이 종료되었습니다.");
        }
    }
}
