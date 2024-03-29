package com.quid.commerce.order.controller.request;

public record PayRequest(Long orderId) {

    public PayRequest {
        if (orderId == null) {
            throw new IllegalArgumentException("orderId must not be null");
        }
    }
}
