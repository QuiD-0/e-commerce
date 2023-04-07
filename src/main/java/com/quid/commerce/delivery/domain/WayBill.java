package com.quid.commerce.delivery.domain;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.quid.commerce.component.SerialNumber;
import com.quid.commerce.order.domain.Order;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "way_bill")
@NoArgsConstructor(access = PROTECTED)
public class WayBill {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String trackingNumber;
    private DeliveryInfo deliveryInfo;
    private Sender sender;
    private Receiver receiver;
    private ShippingAddress shippingAddress;
    @Enumerated(STRING)
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
