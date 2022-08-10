package hello.objprob.charge;

import hello.objprob.member.Member;

import java.util.Map;

public interface ChargePolicy {
    Map<Integer, String> chargeTickets();

}
