package com.quid.commerce.order.usecase;

import com.quid.commerce.order.controller.request.OrderCreateRequest;
import com.quid.commerce.order.repository.OrderRepository;
import com.quid.commerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface OrderCreate {

    void create(OrderCreateRequest request);

    @Service
    @Transactional
    @RequiredArgsConstructor
    class OrderCreateImpl implements OrderCreate {

        private final OrderRepository orderRepository;
        private final ProductRepository productRepository;

        @Override
        public void create(OrderCreateRequest request) {

        }

    }
}
