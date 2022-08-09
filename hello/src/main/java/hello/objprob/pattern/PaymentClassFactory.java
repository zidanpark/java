package hello.objprob.pattern;

import hello.objprob.payment.AccountPaymentClass;
import hello.objprob.payment.CardPaymentClass;
import hello.objprob.payment.PaymentClass;

public class PaymentClassFactory extends ClassFactory {


    @Override
    public PaymentClass createClass(String type) {
        switch ( type ) {
            case "Card" : return new CardPaymentClass();
            case "Account" : return new AccountPaymentClass();
        }

        return null;
    }

}
