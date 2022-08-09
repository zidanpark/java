package hello.objprob.payment;

public class Payment {
    private Long memberId; // 회원 이름
    private int paymentAmt; // 결제 금액
    private String paymentType; // 결제 타입(은행, 카드)
    private String paymentClassType; // 결제 타입 분류(카드사, 은행사)
    private boolean paymentStatus; // 결제 성공 여부

    public Payment(Long memberId, int paymentAmt, String paymentType, String paymentClassType, boolean paymentStatus) {
        this.memberId = memberId;
        this.paymentAmt = paymentAmt;
        this.paymentType = paymentType;
        this.paymentClassType = paymentClassType;
        this.paymentStatus = paymentStatus;
        this.notice();
    }

    public void notice() {
        if(this.paymentStatus) System.out.println("결제에 성공하셨습니다.");
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public int getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(int paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentClassType() {
        return paymentClassType;
    }

    public void setPaymentClassType(String paymentClassType) {
        this.paymentClassType = paymentClassType;
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
