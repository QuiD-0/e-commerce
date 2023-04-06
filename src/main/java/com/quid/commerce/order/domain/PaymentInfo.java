package com.quid.commerce.order.domain;

import static lombok.AccessLevel.PROTECTED;

import com.quid.commerce.component.SerialNumber;
import com.quid.commerce.payment.gateway.model.PaymentResponse;
import java.time.LocalDateTime;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = PROTECTED)
public class PaymentInfo {

    private LocalDateTime paymentRequestDate;
    private LocalDateTime paymentCompleteDate;
    private Integer paymentAmount;
    private String paymentId;
    @Enumerated(EnumType.STRING)
    private PayStatus payStatus;
    private PaymentInfo(Integer paymentAmount) {
        this.paymentRequestDate = LocalDateTime.now();
        this.paymentCompleteDate = LocalDateTime.MIN;
        this.paymentAmount = paymentAmount;
        this.paymentId = SerialNumber.generate();
        this.payStatus = PayStatus.PAYMENT_WAITING;
    }

    public static PaymentInfo init(Integer amount) {
        return new PaymentInfo(amount);
    }

    public void pay(PaymentResponse paymentResponse) {
        this.paymentCompleteDate = LocalDateTime.now();
        this.payStatus = paymentResponse.paymentStatus();
        this.paymentId = paymentResponse.paymentId();
    }
}
