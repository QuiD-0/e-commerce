package com.quid.commerce.order.domain;

import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = PROTECTED)
public class OrdererInfo {

    @Column(name = "orderer_name")
    private String name;
    @Column(name = "orderer_phone_number")
    private String phoneNumber;
    @Column(name = "orderer_email")
    private String email;

    private OrdererInfo(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public static OrdererInfo of(String name, String phoneNumber, String email) {
        return new OrdererInfo(name, phoneNumber, email);
    }
}
