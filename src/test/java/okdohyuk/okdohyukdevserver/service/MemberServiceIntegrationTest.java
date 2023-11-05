package okdohyuk.okdohyukdevserver.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import okdohyuk.okdohyukdevserver.domain.Member;
import okdohyuk.okdohyukdevserver.repository.MemberRepository;

import static org.assertj.core.api.Assertions.*;

// Transactional를 사용하면 테스트마다 롤백을 자동으로 해줌
@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void testJoin() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);
        // then
        Member findMember = memberService.findOne(saveId);
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("hello");

        Member member2 = new Member();
        member2.setName("hello");
        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        /*
         * try {
         * memberService.join(member2);
         * } catch (IllegalStateException e) {
         * assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
         * }
         */
        // then
    }
}
