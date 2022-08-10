package hello.objprob.payment;

public class Payment {
    private Long memberId; // 회원 이름
    private int paymentAmt; // 결제 금액
    private String paymentType; // 결제 타입(은행, 카드)
    private String paymentClassType; // 결제 타입 분류(카드사, 은행사)
    private boolean paymentStatus; // 결제 성공 여부

    public Payment(Long memberId, int paymentAmt, String paymentType, String paymentClassType) throws Exception {
        this.memberId = memberId;
        this.paymentAmt = paymentAmt;
        this.paymentType = paymentType;
        this.paymentClassType = paymentClassType;
        this.payExecute();
    }

    private void payExecute() throws Exception
    {
        System.out.println("결제 진행 중...");
        int flag = (int)((Math.random()*10000)%10);
        if(flag <= 0) throw new Exception("결제 실패");
        System.out.println("결제 성공");
        this.paymentStatus = true;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "memberId=" + memberId +
                ", paymentAmt=" + paymentAmt +
                ", paymentType='" + paymentType + '\'' +
                ", paymentClassType='" + paymentClassType + '\'' +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
