package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        // 테스트 실행하기 전 실행된다.
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given 조건이 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when 이렇게 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then 결과
        // member는 findMember와 똑같은지 체크
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
