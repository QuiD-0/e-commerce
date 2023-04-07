package com.quid.commerce.order.domain;

import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = PROTECTED)
public class OrdererInfo {

    private String ordererName;
    private String ordererPhoneNumber;
    private String ordererEmail;

    private OrdererInfo(String ordererName, String ordererPhoneNumber, String ordererEmail) {
        this.ordererName = ordererName;
        this.ordererPhoneNumber = ordererPhoneNumber;
        this.ordererEmail = ordererEmail;
    }

    public static OrdererInfo of(String name, String phoneNumber, String email) {
        return new OrdererInfo(name, phoneNumber, email);
    }
}
