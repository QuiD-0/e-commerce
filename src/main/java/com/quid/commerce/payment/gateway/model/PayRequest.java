package com.quid.commerce.payment.gateway.model;

public record PayRequest(Long orderId) {

    public PayRequest {
        if (orderId == null) {
            throw new IllegalArgumentException("orderId must not be null");
        }
    }
}
