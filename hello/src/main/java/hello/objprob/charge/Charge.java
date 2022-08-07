package hello.objprob.charge;

public class Charge {
    private Long memberId;
    private String ticketName;
    private String memberName;
    private int ticketAmt;
    private int balanceAmt;
    private int beforeBalanceAmt;
    private boolean chargeStatus;

    public Charge(Long memberId, String memberName, String ticketName, int ticketAmt, int balanceAmt, boolean chargeStatus) {
        this.memberId = memberId;
        this.ticketName = ticketName;
        this.memberName = memberName;
        this.ticketAmt = ticketAmt;
        this.balanceAmt = balanceAmt;
        this.chargeStatus = chargeStatus;
        this.calculateBalance();

    }

    public int calculateBalance(){
        this.beforeBalanceAmt = this.balanceAmt;
        if(this.chargeStatus != false) {
            this.balanceAmt = this.balanceAmt + this.ticketAmt;
        }
        return this.balanceAmt;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public int getTicketAmt() {
        return ticketAmt;
    }

    public void setTicketAmt(int ticketAmt) {
        this.ticketAmt = ticketAmt;
    }

    public int getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(int balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public boolean isChargeStatus() {
        return chargeStatus;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setChargeStatus(boolean chargeStatus) {
        this.chargeStatus = chargeStatus;
    }

    @Override
    public String toString() {


        return "Charge{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", ticketName='" + ticketName + '\'' +
                ", ticketAmt=" + ticketAmt +
                ", beforeBalanceAmt=" + this.beforeBalanceAmt +
                ", afterBalanceAmt=" + this.balanceAmt +
                ", chargeStatus=" + ( chargeStatus ? "성공" : "실패" ) +
                '}';
    }
}
