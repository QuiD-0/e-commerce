package com.quid.commerce.payment.gateway.model;

import com.quid.commerce.order.domain.Order;

public record PaymentRequest(Long orderId, Integer amount, String ordererName, String ordererEmail) {

    public static PaymentRequest of(Order order) {
        return new PaymentRequest(order.getId(), order.getTotalPrice(), order.getOrdererInfo().getName(), order.getOrdererInfo().getEmail());
    }
}
