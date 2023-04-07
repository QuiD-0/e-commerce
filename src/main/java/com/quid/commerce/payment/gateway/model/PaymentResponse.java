package com.quid.commerce.payment.gateway.model;

import com.quid.commerce.component.SerialNumber;
import com.quid.commerce.order.domain.PayStatus;

public record PaymentResponse(String paymentId, PayStatus paymentStatus, Long orderId) {

    public static PaymentResponse of(PaymentRequest request) {
        return new PaymentResponse(SerialNumber.generate(), PayStatus.PAYMENT_COMPLETED, request.orderId());
    }
}
