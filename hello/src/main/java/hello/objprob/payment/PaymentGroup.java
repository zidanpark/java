package hello.objprob.payment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum PaymentGroup {
    CARD("신용카드", Arrays.asList("우리카드", "국민카드", "하나카드","롯데카드")),
    ACCOUNT("계좌이체", Arrays.asList("우리은행", "국민은행", "하나은행","신한은행")),
    EMPTY("없음", Collections.EMPTY_LIST);


    private String title;
    private List<String> payList;
    private String selectLists = "";

    PaymentGroup(String title, List<String> payList) {
        this.title = title;
        this.payList = payList;
    }

    public static PaymentGroup findByPayCode(String code){
        return Arrays.stream(PaymentGroup.values())
                        .filter(pg -> pg.hasPayCode(code))
                        .findAny()
                        .orElse(EMPTY);
    }

    public boolean hasPayCode(String code){
        return payList.stream()
                .anyMatch(pay -> pay.equals(code));
    }

    public String getTitle() { return title;}
    public String getLists() {
        payList.forEach(s -> {
            this.selectLists += (payList.indexOf(s)+1)+". "+s;
            if(payList.indexOf(s) < payList.size()-1) this.selectLists += ", ";
        });
        return this.selectLists;
    }

    public String getPayType(int idx) {
        return payList.get(idx);
    }

}
