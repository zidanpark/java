package hello.core.member2;

import hello.core.member2.Member;

public interface MemberService {

    void join(hello.core.member2.Member member);

    Member findMember(Long memberId);
}

