package hello.objprob.payment;

import java.util.List;
import java.util.Scanner;

public class CardPaymentClass implements PaymentClass {

    @Override
    public void payModuleCall() {
        System.out.println("카드 충전 모듈을 호출하셨습니다.");
    }

    @Override
    public String getPayType() {
        String pgs = PaymentGroup.CARD.getLists();
        return pgs;
    }

    @Override
    public String selectPayType() {
        String pgs = this.getPayType();
        System.out.println("결제 수단을 입력해주세요");
        System.out.println(pgs);
        Scanner scan = new Scanner( System.in );
        int N=scan.nextInt();
        String pg = PaymentGroup.CARD.getPayType(N-1);
        System.out.println(pg+"로 선택하셨습니다.");
        return pg;
    }

}
