package com.quid.commerce.payment.gateway.model;

import com.quid.commerce.order.domain.PayStatus;
import java.time.LocalDate;

public record PaymentResponse(String requestId, LocalDate createdAt, String paymentId, PayStatus paymentStatus, Integer paymentAmount) {

    public boolean payComplete() {
        return paymentStatus == PayStatus.PAYMENT_COMPLETED;
    }
}
