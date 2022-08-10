package hello.objprob.charge;

import hello.objprob.member.Member;
import hello.objprob.member.PlanType;

import java.util.HashMap;
import java.util.Map;

public class FlatRateChargePolicy implements ChargePolicy, ChargeCheck {
    @Override
    public Map<Integer, String> chargeTickets() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(36300, (36300)+"원권");
        map.put(56300, (56300)+"원권");

        return map;
    }

    @Override
    public boolean isChargeCheck(Member member, int ticketAmt) throws Exception {
        if(member.getType() != PlanType.FlatRate) throw new Exception("저는 선불 정액 요금이 아니라 정액 요금 충전이 불가능합니다.");
        if(this.chargeTickets().get(ticketAmt) == null) throw new Exception("충전 가능한 금액이 아닙니다.");

        System.out.println("저는 선불 정액 요금! 충전이 가능합니다.");
        return true;
    }
}
