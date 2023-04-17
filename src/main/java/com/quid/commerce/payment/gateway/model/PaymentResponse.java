package com.quid.commerce.payment.gateway.model;

import com.quid.commerce.order.domain.PayStatus;
import java.time.LocalDate;

public record PaymentResponse(String requestId, LocalDate createdAt, String paymentId, PayStatus payStatus, Integer payAmount) {

    public boolean payComplete() {
        return payStatus == PayStatus.PAYMENT_COMPLETED;
    }
}
