package hello.objprob.charge;

import hello.objprob.member.Member;

/**
 * @DESC 실행 관련 인터페이스
 */
public interface ChargeService {

    Charge createCharge(Long memberId, String ticketName, int ticketAmt, int balanceAmt);
    boolean isCharge(Member member, int ticketAmt);
}
