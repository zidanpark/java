package hello.core.member2;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
