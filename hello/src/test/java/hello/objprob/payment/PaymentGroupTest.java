package hello.objprob.payment;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentGroupTest {
    @Test
    public void 결제종류찾기() throws Exception {
        String payCode = "KB";
        PaymentGroup paymentGroup = PaymentGroup.findByPayCode(payCode);

        assertThat(paymentGroup.name().equals("WOORI"));

    }

}