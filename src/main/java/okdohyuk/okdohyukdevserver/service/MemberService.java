package okdohyuk.okdohyukdevserver.service;

import java.util.List;

import okdohyuk.okdohyukdevserver.domain.Member;
import okdohyuk.okdohyukdevserver.repository.MemberRepository;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /** 회원가입 */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원X
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /** 전체 회원 조회 */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /** 회원 조회 */
    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }
}
