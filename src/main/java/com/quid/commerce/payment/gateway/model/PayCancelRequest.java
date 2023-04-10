package com.quid.commerce.payment.gateway.model;

public record PayCancelRequest(String paymentId) {

    public static PayCancelRequest of(String paymentId) {
        return new PayCancelRequest(paymentId);
    }
}
