package hello.core;

import hello.core.member2.Member;
import hello.core.member2.MemberService;
import hello.core.member2.MemberServiceImpl;
import hello.core.member2.Grade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Member2App {
    public static void main(String[] args){
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+ member.getName() + ", new plantype = "+ member.getGrade());
        System.out.println("find member = "+ findMember.getName() + ", find plantype = "+ findMember.getGrade());
    }
}
