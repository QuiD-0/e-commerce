package com.quid.commerce.order.usecase;

import com.quid.commerce.order.controller.request.OrderCreateRequest;
import com.quid.commerce.order.domain.Order;
import com.quid.commerce.order.repository.OrderRepository;
import com.quid.commerce.product.domain.Product;
import com.quid.commerce.product.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface OrderCreate {

    Order create(OrderCreateRequest request);

    @Service
    @Transactional
    @RequiredArgsConstructor
    class OrderCreateImpl implements OrderCreate {

        private final OrderRepository orderRepository;
        private final ProductRepository productRepository;

        @Override
        public Order create(OrderCreateRequest request) {
            List<Product> foundProducts = productRepository.findProductsByIds(request.productIds());
            Order order = Order.create(foundProducts, request.ordererInfo());
            return orderRepository.save(order);
        }

    }
}
