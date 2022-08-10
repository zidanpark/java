package hello.objprob.charge;

public class Charge {
    private Long memberId;
    private String ticketName;
    private String memberName;
    private int ticketAmt;
    private int balanceAmt;
    private int beforeBalanceAmt;
    private boolean chargeStatus;

    public Charge(Long memberId, String memberName, String ticketName, int ticketAmt, int balanceAmt) throws Exception {
        this.memberId = memberId;
        this.ticketName = ticketName;
        this.memberName = memberName;
        this.ticketAmt = ticketAmt;
        this.balanceAmt = balanceAmt;
        this.chargeExecute();
        this.calculateBalance();


    }

    private void chargeExecute() throws Exception {
        System.out.println("충전 진행 중...");
        int flag = (int)((Math.random()*10000)%10);
        if(flag <= 0) throw new Exception("충전 실패");
        System.out.println("충전 성공");
        this.chargeStatus = true;
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

    public int getBalanceAmt() {
        return balanceAmt;
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
