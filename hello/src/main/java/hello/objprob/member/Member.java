package hello.objprob.member;

import hello.objprob.member.PlanType;

public class Member {

    private Long id;
    private String name;
    private PlanType type;

    private int balanceAmt;


    public Member(Long id, String name, PlanType type, int balanceAmt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.balanceAmt = balanceAmt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlanType getType() {
        return type;
    }

    public void setType(PlanType type) {
        this.type = type;
    }

    public int getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(int balanceAmt) {
        this.balanceAmt = balanceAmt;
    }
}
