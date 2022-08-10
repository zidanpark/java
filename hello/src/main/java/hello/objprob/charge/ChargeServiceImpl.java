package hello.objprob.charge;

import hello.objprob.member.Member;
import hello.objprob.member.MemberRepository;
import hello.objprob.member.MemoryMemberRepository;
import hello.objprob.member.PlanType;
import hello.objprob.payment.Payment;

public class ChargeServiceImpl implements ChargeService{
    // final이 쓰인 이유 - memberRepository에 한번 객체가 등록되면 다른 객체로 변경 불가 하게 하기 위해.
    private final MemberRepository memberRepository;
    private final ChargeCheck chargeCheck;


    public ChargeServiceImpl(MemberRepository memberRepository, ChargeCheck chargeCheck) {
        this.memberRepository = memberRepository;
        this.chargeCheck = chargeCheck;
    }

    @Override
    public Charge createCharge(Long memberId,String ticketName, int ticketAmt, int balanceAmt) throws Exception{
        Member member = memberRepository.findById(memberId);
        if(!chargeCheck.isChargeCheck(member,ticketAmt)) throw new Exception("충전 불가능한 요금제");
        return new Charge(memberId, member.getName(), ticketName, ticketAmt, balanceAmt);
    }
}
