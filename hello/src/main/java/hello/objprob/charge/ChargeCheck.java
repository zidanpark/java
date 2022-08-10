package hello.objprob.charge;

import hello.objprob.member.Member;

import java.util.Map;

public interface ChargeCheck {
    boolean isChargeCheck(Member member, int ticketAmt) throws Exception;
}
