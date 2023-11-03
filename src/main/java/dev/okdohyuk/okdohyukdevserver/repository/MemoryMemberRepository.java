package dev.okdohyuk.okdohyukdevserver.repository;

import java.util.Optional;

/**
 * MemoryMemberRepository
 */
public class MemoryMemberRepository {

    private Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public void findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // public void deleteById(Long id) {
    // store.remove(id);
    // }

    // public void update(Long id, Member member) {
    // store.put(id, member);
    // }
}