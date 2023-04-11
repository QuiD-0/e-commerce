package com.quid.commerce.order.repository;

import com.quid.commerce.order.domain.Order;
import com.quid.commerce.payment.gateway.model.PaymentResponse;

public class FakeOrderRepository implements OrderRepository{

    @Override
    public Order save(Order order) {
        return order;
    }

    @Override
    public Order findOrder(Long orderId) {
        return null;
    }

    @Override
    public Order findOrder(String orderNumber) {
        return null;
    }

    @Override
    public void pay(Order orderId, PaymentResponse paymentResponse) {

    }

}
