package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //Spring Container
        //AppConfig에서 Bean으로 등록한 것을 객체로 생성에서 관리한다 스프링에서
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //Spring 컨테이너를 통해서 MemberService를 찾아야 한다.
        //getBean에 매개변수로 빈의 이름, 빈 타입을 넘겨줘야한다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member);
        System.out.println("findMember = " + findMember);
    }
}
