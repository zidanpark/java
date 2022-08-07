package hello.objprob;

import hello.objprob.AppConfig;
import hello.objprob.member.Member;
import hello.objprob.member.MemberService;
import hello.objprob.member.MemberServiceImpl;
import hello.objprob.member.PlanType;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", PlanType.Prepaid, 0);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+ member.getName() + ", new plantype = "+ member.getType());
        System.out.println("find member = "+ findMember.getName() + ", find plantype = "+ findMember.getType());
    }
}
