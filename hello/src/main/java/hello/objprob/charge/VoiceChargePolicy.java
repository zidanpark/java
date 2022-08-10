package hello.objprob.charge;

import hello.objprob.member.Member;
import hello.objprob.member.PlanType;

import java.util.HashMap;
import java.util.Map;

public class VoiceChargePolicy implements ChargePolicy, ChargeCheck{

    /**
     * @Desc 권종 리스트 등록
     * @Return map 권종리스트
     */
    @Override
    public  Map<Integer, String> chargeTickets() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        for(int i=0; i<10; i++){
            int amt = (i+1)*1000;
            map.put(amt, (amt)+"원권");
        }

        return map;
    }

    /**
     * @Desc 충전 가능여부 체크
     * @Return boolean 참/거짓
     */
    @Override
    public boolean isChargeCheck(Member member, int ticketAmt) throws Exception{
        if(member.getType() != PlanType.Prepaid) throw new Exception("저는 선불 요금이 아니라 음성 요금 충전이 불가능합니다.");
        if(this.chargeTickets().get(ticketAmt) == null) throw new Exception("충전 가능한 금액이 아닙니다.");

        System.out.println("저는 선불 요금! 충전이 가능합니다.");
        return true;
    }
}