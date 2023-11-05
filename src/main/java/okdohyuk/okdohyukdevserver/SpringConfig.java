package okdohyuk.okdohyukdevserver;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import okdohyuk.okdohyukdevserver.repository.JdbcMemberRepository;
import okdohyuk.okdohyukdevserver.repository.JdbcTemplateMemberRepository;
import okdohyuk.okdohyukdevserver.repository.MemberRepository;
// import okdohyuk.okdohyukdevserver.repository.MemoryMemberRepository;
import okdohyuk.okdohyukdevserver.service.MemberService;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
