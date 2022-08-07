package hello.objprob.charge;

import hello.objprob.member.Member;
import hello.objprob.member.PlanType;

import java.util.HashMap;
import java.util.Map;

public class FlatRateChargePolicy implements ChargePolicy{
    private Map<Integer, String> tickets;

    public FlatRateChargePolicy() {
        this.chargeTickets();
    }

    @Override
    public void chargeTickets() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(36300, (36300)+"원권");

        this.tickets = map;
    }

    @Override
    public boolean isCharging(Member member, int ticketAmt) {
        if(member.getType() != PlanType.FlatRate) {
            System.out.println("저는 선불 정액 요금이 아니라 정액 요금 충전이 불가능합니다.");
            return false;
        }

        if(tickets.get(ticketAmt) == null){
            System.out.println("충전 가능한 요금이 아닙니다.");
            return false;
        }

        System.out.println("저는 선불 정액 요금! 충전이 가능합니다.");
        return true;
    }
}
