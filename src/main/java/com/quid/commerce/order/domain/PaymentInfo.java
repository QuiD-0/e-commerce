package com.quid.commerce.order.domain;

import com.quid.commerce.payment.gateway.model.PaymentResponse;
import java.time.LocalDateTime;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;

@Getter
@Embeddable
public class PaymentInfo {

    private LocalDateTime paymentRequestDate;
    private LocalDateTime paymentCompleteDate;
    private Integer paymentAmount;
    private String paymentId;
    @Enumerated(EnumType.STRING)
    private PayStatus payStatus;

    public PaymentInfo() {
        this.paymentRequestDate = LocalDateTime.now();
        this.paymentCompleteDate = null;
        this.paymentAmount = 0;
        this.paymentId = "";
        this.payStatus = PayStatus.PAYMENT_WAITING;
    }

    public static PaymentInfo init() {
        return new PaymentInfo();
    }

    public void pay(PaymentResponse paymentResponse) {
        this.paymentCompleteDate = LocalDateTime.now();
        this.payStatus = paymentResponse.paymentStatus();
        this.paymentId = paymentResponse.paymentId();
        this.paymentAmount = paymentResponse.paymentAmount();
    }
}
