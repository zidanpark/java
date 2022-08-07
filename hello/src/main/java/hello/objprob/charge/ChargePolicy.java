package hello.objprob.charge;

import hello.objprob.member.Member;

public interface ChargePolicy {
    void chargeTickets();
    boolean isCharging(Member member, int ticketAmt);
}
