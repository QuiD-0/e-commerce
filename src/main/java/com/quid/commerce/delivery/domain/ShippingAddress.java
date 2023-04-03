package com.quid.commerce.delivery.domain;

import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = PROTECTED)
public class ShippingAddress {

    @Column(name = "shipping_address")
    private String ShippingAddress;

    private ShippingAddress(String ShippingAddress) {
        if(ShippingAddress == null || ShippingAddress.isEmpty()) {
            throw new IllegalArgumentException("ShippingAddress must not be null or empty");
        }
        this.ShippingAddress = ShippingAddress;
    }

    public static ShippingAddress of(String ShippingAddress) {
        return new ShippingAddress(ShippingAddress);
    }

}
