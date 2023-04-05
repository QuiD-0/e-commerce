package com.quid.commerce.delivery.domain;

import static lombok.AccessLevel.PROTECTED;

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
    @Column(name = "receiver_address")
    private String address;

    private Receiver(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public static Receiver of(String name, String phone, String email, String address) {
        return new Receiver(name, phone, email, address);
    }
}
