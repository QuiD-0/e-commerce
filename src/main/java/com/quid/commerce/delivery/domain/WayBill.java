package com.quid.commerce.delivery.domain;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.quid.commerce.component.SerialNumber;
import com.quid.commerce.order.domain.Order;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class WayBill {

    @Id
    @Column(name = "waybill_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "tracking_number")
    private String trackingNumber;
    @Column(name = "delivery_info")
    private DeliveryInfo deliveryInfo;
    @Column(name = "sender")
    private Sender sender;
    @Column(name = "receiver")
    private Receiver receiver;
    @Column(name = "shipping_address")
    private ShippingAddress shippingAddress;
    @Enumerated(STRING)
    @Column(name = "delivery_status")
    private DeliveryStatus deliveryStatus;
    @OneToOne(fetch = LAZY)
    private Order order;
    private WayBill(String memo, Sender sender, Receiver receiver, String shippingAddress, Order order) {
        this.trackingNumber = SerialNumber.generate();
        this.deliveryInfo = DeliveryInfo.of(memo);
        this.sender = sender;
        this.receiver = receiver;
        this.shippingAddress = ShippingAddress.of(shippingAddress);
        this.deliveryStatus = DeliveryStatus.READY;
        this.order = order;
    }

    public static WayBill of(Sender sender, Receiver receiver, String shippingAddress, String memo, Order order) {
        return new WayBill(memo, sender, receiver, shippingAddress, order);
    }
}
