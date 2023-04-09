package com.quid.commerce.order.controller.request;

public record OrderPayRequest(Long orderId) {

    public OrderPayRequest {
        if (orderId == null) {
            throw new IllegalArgumentException("orderId must not be null");
        }
    }
}
