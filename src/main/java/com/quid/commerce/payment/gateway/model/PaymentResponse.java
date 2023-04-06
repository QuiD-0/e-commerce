package com.quid.commerce.payment.gateway.model;

import com.quid.commerce.order.domain.PayStatus;

public record PaymentResponse(String paymentId, PayStatus paymentStatus) {

}
