package com.quid.commerce.delivery.domain;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class WayBill {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private TrackingNumber trackingNumber;
    private DeliveryInfo deliveryInfo;
    private Sender sender;
    private Receiver receiver;
    private ShippingAddress shippingAddress;
    @Enumerated(STRING)
    private DeliveryStatus deliveryStatus;

    private WayBill(String memo, Sender sender, Receiver receiver, String shippingAddress) {
        this.trackingNumber = TrackingNumber.create();
        this.deliveryInfo = DeliveryInfo.of(memo);
        this.sender = sender;
        this.receiver = receiver;
        this.shippingAddress = ShippingAddress.of(shippingAddress);
        this.deliveryStatus = DeliveryStatus.READY;
    }

    public static WayBill of(Sender sender, Receiver receiver, String shippingAddress, String memo) {
        return new WayBill(memo, sender, receiver, shippingAddress);
    }
}
