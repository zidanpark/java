package hello.objprob;

import hello.objprob.AppConfig;
import hello.objprob.charge.Charge;
import hello.objprob.charge.ChargeService;
import hello.objprob.charge.ChargeServiceImpl;
import hello.objprob.member.Member;
import hello.objprob.member.MemberService;
import hello.objprob.member.MemberServiceImpl;
import hello.objprob.member.PlanType;

/**
 * @Desc 충전 로직
 * @Wants 결제 로직 & H2 DB로 변경
 */

public class ChargeApp {

    public static void main(String[] args) {
        int ticketAmt = 1000;

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        ChargeService chargeService = appConfig.chargeService("Voice");

        Member member = new Member(1L, "memberA", PlanType.Prepaid, 9999);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        Charge charge = chargeService.createCharge(findMember.getId(), "ticketA", ticketAmt, findMember.getBalanceAmt());

        System.out.println(charge);
        System.out.println("잔액 : " + charge.getBalanceAmt());
    }
}
