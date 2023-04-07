package com.quid.commerce.delivery.domain;

import static lombok.AccessLevel.PROTECTED;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = PROTECTED)
public class DeliveryInfo {

    @Column(name = "delivery_start_date")
    private LocalDateTime deliveryStartDate;
    @Column(name = "delivery_end_date")
    private LocalDateTime deliveryEndDate;
    @Column(name = "memo")
    private String memo;

    private DeliveryInfo(String memo) {
        this.deliveryStartDate = LocalDateTime.now();
        this.deliveryEndDate = null;
        this.memo = memo == null ? "" : memo;
    }

    public static DeliveryInfo of(String memo) {
        return new DeliveryInfo(memo);
    }
}
