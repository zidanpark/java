package hello.objprob.charge;

import hello.objprob.member.Member;

public interface ChargeService {

    Charge createCharge(Long memberId, String ticketName, int ticketAmt, int balanceAmt);
    boolean isCharge(Member member, int ticketAmt);
}
