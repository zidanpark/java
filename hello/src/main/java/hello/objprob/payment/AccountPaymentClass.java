package hello.objprob.payment;

import java.util.Scanner;

public class AccountPaymentClass implements PaymentClass {


    public AccountPaymentClass(){
        System.out.println("계좌이체 결제 모듈 시작");
    }

    @Override
    public String getPayType() {
        String pgs = PaymentGroup.ACCOUNT.getLists();
        return pgs;
    }

    @Override
    public String selectPayType(String pgs) {
        System.out.println("결제 수단을 입력해주세요");
        System.out.println(pgs);
        Scanner scan = new Scanner( System.in );
        int N=scan.nextInt();
        String pg = PaymentGroup.ACCOUNT.getPayType(N-1);
        System.out.println(pg+"으로 선택하셨습니다.");
        return pg;
    }
}
