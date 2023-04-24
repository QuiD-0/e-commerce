package com.quid.commerce.payment;

import com.quid.commerce.payment.gateway.out.PaymentGateway;
import com.quid.commerce.payment.gateway.model.PayCancelRequest;
import com.quid.commerce.payment.gateway.model.PaymentRequest;
import com.quid.commerce.payment.gateway.model.PaymentResponse;

public class FakePaymentGateway implements PaymentGateway {

    @Override
    public PaymentResponse payRequest(PaymentRequest paymentRequest) {
        return null;
    }

    @Override
    public void cancelRequest(PayCancelRequest cancelRequest) {

    }

}
