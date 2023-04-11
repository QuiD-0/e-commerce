package com.quid.commerce.order.repository;

import com.quid.commerce.order.domain.Order;
import java.util.List;

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
    public List<Order> findByOrderer(String ordererName) {
        return null;
    }

}
