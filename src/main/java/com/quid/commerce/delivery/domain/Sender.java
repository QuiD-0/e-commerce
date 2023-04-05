package com.quid.commerce.delivery.domain;

import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Embeddable
@NoArgsConstructor(access = PROTECTED)
public class Sender {

    @Column(name = "sender_name")
    private String name;
    @Column(name = "sender_phone")
    private String phone;
    @Column(name = "sender_email")
    private String email;
    @Column(name = "sender_address")
    private String address;

    private Sender(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public static Sender of(String name, String phone, String email, String address) {
        return new Sender(name, phone, email, address);
    }

}
