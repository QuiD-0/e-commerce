package com.quid.commerce.payment.gateway.model;

import com.quid.commerce.order.domain.Order;

public record PaymentRequest(Long orderId, Integer amount, String ordererName, String ordererEmail) {

    public static PaymentRequest of(Order order) {
        return new PaymentRequest(order.getId(), order.getPaymentInfo().getPaymentAmount(), order.getOrdererInfo().getOrdererName(), order.getOrdererInfo().getOrdererEmail());
    }
}
