package com.quid.commerce.payment;

import static com.quid.commerce.order.domain.PayStatus.PAYMENT_COMPLETED;

import com.quid.commerce.payment.gateway.PaymentGateway;
import com.quid.commerce.payment.gateway.model.PayCancelRequest;
import com.quid.commerce.payment.gateway.model.PaymentRequest;
import com.quid.commerce.payment.gateway.model.PaymentResponse;

public class FakePaymentGateway implements PaymentGateway {

    @Override
    public PaymentResponse payRequest(PaymentRequest paymentRequest) {
        return new PaymentResponse("fakePaymentId", PAYMENT_COMPLETED, 1L, 10000);
    }

    @Override
    public void cancelRequest(PayCancelRequest cancelRequest) {

    }

}
