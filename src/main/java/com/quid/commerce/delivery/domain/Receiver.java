package com.quid.commerce.delivery.domain;

import static lombok.AccessLevel.PROTECTED;

import com.quid.commerce.order.domain.OrdererInfo;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = PROTECTED)
public class Receiver {

    @Column(name = "receiver_name")
    private String name;
    @Column(name = "receiver_phone")
    private String phone;
    @Column(name = "receiver_email")
    private String email;

    private Receiver(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public static Receiver of(String name, String phone, String email) {
        return new Receiver(name, phone, email);
    }

    public static Receiver of(OrdererInfo ordererInfo) {
        return new Receiver(ordererInfo.getName(), ordererInfo.getPhoneNumber(), ordererInfo.getEmail());
    }
}
