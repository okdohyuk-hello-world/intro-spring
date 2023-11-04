package okdohyuk.okdohyukdevserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okdohyuk.okdohyukdevserver.repository.MemberRepository;
import okdohyuk.okdohyukdevserver.repository.MemoryMemberRepository;
import okdohyuk.okdohyukdevserver.service.MemberService;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
