package com.quid.commerce.order.usecase;

import com.quid.commerce.order.controller.request.OrderCreateRequest;
import com.quid.commerce.order.repository.FakeOrderRepository;
import com.quid.commerce.order.repository.OrderRepository;
import com.quid.commerce.order.usecase.OrderCreate.OrderCreateImpl;
import com.quid.commerce.product.repository.FakeProductRepository;
import com.quid.commerce.product.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderCreateTest {

    private OrderCreate orderCreate;

    @BeforeEach
    void setUp() {
        OrderRepository orderRepository = new FakeOrderRepository();
        ProductRepository productRepository = new FakeProductRepository();
        orderCreate = new OrderCreateImpl(orderRepository, productRepository);
    }

    @Test
    @DisplayName("주문 정보 부족시 실패")
    void orderCreateFailTest() {

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> orderCreate.create(new OrderCreateRequest(null, null))
        );

    }

}