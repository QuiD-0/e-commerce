package com.quid.commerce.order.domain;

import java.time.LocalDateTime;
import javax.persistence.Embeddable;

@Embeddable
public class PaymentHistory {

    private String paymentMethod;
    private LocalDateTime paymentDate;
    private Integer paymentAmount;
    private String paymentId;

}
