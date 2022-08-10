package hello.objprob.charge;

import hello.objprob.member.Member;
import hello.objprob.member.MemberRepository;
import hello.objprob.member.MemoryMemberRepository;

public class ChargeServiceImpl implements ChargeService{
    // final이 쓰인 이유 - memberRepository에 한번 객체가 등록되면 다른 객체로 변경 불가 하게 하기 위해.
    private final MemberRepository memberRepository;
    private final ChargePolicy chargePolicy;

    public ChargeServiceImpl(MemberRepository memberRepository, ChargePolicy chargePolicy) {
        this.memberRepository = memberRepository;
        this.chargePolicy = chargePolicy;
    }

    @Override
    public Charge createCharge(Long memberId,String ticketName, int ticketAmt, int balanceAmt) {
        Member member = memberRepository.findById(memberId);
        return new Charge(memberId, member.getName(), ticketName, ticketAmt, balanceAmt, chargePolicy.isCharging(member,ticketAmt));
    }

    @Override
    public boolean isCharge(Member member, int ticketAmt) {
        return chargePolicy.isCharging(member,ticketAmt);
    }
}
