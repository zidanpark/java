package hello.objprob.pattern;

import hello.objprob.charge.ChargePolicy;

public abstract class PolicyFactory {
    public abstract ChargePolicy createPolicy(String type);
}
