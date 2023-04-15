package com.quid.commerce.payment.gateway.model;

import com.quid.commerce.order.domain.Order;
import java.time.LocalDate;

public record PaymentRequest(String requestId, String identifier, Integer price, Card card) {

    public static PaymentRequest of(Order order) {
        return new PaymentRequest(order.getOrderNumber(), "commerce", order.getTotalPrice(), Card.fixture());
    }
    private record Card(String number, LocalDate expireDate, String cvc, String holderName) {
        static Card fixture() {
            return new Card("1234567890123456", LocalDate.of(2026, 12, 31), "628", "QuiD");
        }
    }
}
