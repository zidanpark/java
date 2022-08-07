package hello.core.member2;

import hello.core.member2.Member;
import hello.core.member2.MemberRepository;
import hello.core.member2.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(hello.core.member2.Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
