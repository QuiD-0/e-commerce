package com.quid.commerce.order.repository;

import com.quid.commerce.order.domain.Order;

public class FakeOrderRepository implements OrderRepository{

    @Override
    public Order save(Order order) {
        return order;
    }
}
