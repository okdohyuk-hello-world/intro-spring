package okdohyuk.okdohyukdevserver.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import okdohyuk.okdohyukdevserver.domain.Member;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new MemoryMemberRepository();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("John Doe");

        repository.save(member);

        Member result = repository.findById(member.getId()).orElse(null);
        assertEquals(member, result);
    }

    @Test
    public void findById() {
        Member member1 = new Member();
        member1.setName("John Doe");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Jane Doe");
        repository.save(member2);

        Member result = repository.findById(member1.getId()).orElse(null);
        assertEquals(member1, result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("John Doe");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Jane Doe");
        repository.save(member2);

        Member result = repository.findByName("John Doe").orElse(null);
        assertEquals(member1, result);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("John Doe");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Jane Doe");
        repository.save(member2);

        assertEquals(2, repository.findAll().size());
    }

    // @Test
    // public void deleteById() {
    // Member member1 = new Member();
    // member1.setName("John Doe");
    // repository.save(member1);

    // Member member2 = new Member();
    // member2.setName("Jane Doe");
    // repository.save(member2);

    // repository.deleteById(member1.getId());

    // assertNull(repository.findById(member1.getId()).orElse(null));
    // assertEquals(1, repository.findAll().size());
    // }

    // @Test
    // public void clear() {
    // Member member1 = new Member();
    // member1.setName("John Doe");
    // repository.save(member1);

    // Member member2 = new Member();
    // member2.setName("Jane Doe");
    // repository.save(member2);

    // repository.clear();

    // assertEquals(0, repository.findAll().size());
    // }
}
