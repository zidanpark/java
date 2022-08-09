package hello.objprob.pattern;

import hello.objprob.payment.PaymentClass;

public abstract class ClassFactory {
    public abstract PaymentClass createClass(String type);
}
