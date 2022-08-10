package hello.objprob.payment;

import java.util.List;

public interface PaymentClass {
    boolean payCheckFlag = false;
    boolean payFlag = false;

    void payModuleCall();
    String getPayType();
    String selectPayType();

    boolean payExecute();

}
