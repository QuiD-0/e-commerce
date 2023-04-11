package com.quid.commerce.order.controller.response;

import com.quid.commerce.delivery.domain.DeliveryStatus;
import com.quid.commerce.delivery.domain.WayBill;
import com.quid.commerce.order.domain.Order;
import com.quid.commerce.order.domain.OrderStatus;
import com.quid.commerce.order.domain.PayStatus;
import java.time.LocalDateTime;

public record OrderInfoResponse(String name, String orderNumber, String wayBillNumber,
                                OrderStatus orderStatus, PayStatus paymentStatus,
                                DeliveryStatus deliveryStatus, String deliveryAddress,
                                LocalDateTime orderDate) {

    public static OrderInfoResponse of(WayBill wayBill, Order order){
        return new OrderInfoResponse(order.getOrdererInfo().getName(), order.getOrderNumber(), wayBill.getTrackingNumber(),
                order.getOrderStatus(), order.getPaymentInfo().getPayStatus(), wayBill.getDeliveryStatus(),
                wayBill.shippingAddress(), order.getCreatedAt());
    }

}
