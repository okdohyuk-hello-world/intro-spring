package dev.okdohyuk.okdohyukdevserver.repository;

import dev.okdohyuk.okdohyukdevserver.domain.Member;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}