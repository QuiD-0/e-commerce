package com.quid.commerce.order.repository;

import com.quid.commerce.order.domain.Order;
import com.quid.commerce.order.repository.jpa.JpaOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface OrderRepository {

    Order save(Order order);

    Order findOrder(Long orderId);
    Order findOrder(String orderNumber);

    @Repository
    @RequiredArgsConstructor
    class OrderRepositoryImpl implements OrderRepository {
        private final JpaOrderRepository jpaOrderRepository;

        @Override
        public Order save(Order order) {
            return jpaOrderRepository.save(order);
        }

        @Override
        public Order findOrder(Long orderId) {
            return jpaOrderRepository.findById(orderId).orElseThrow(IllegalStateException::new);
        }

        @Override
        public Order findOrder(String orderNumber) {
            return jpaOrderRepository.findByOrderNumber(orderNumber).orElseThrow(IllegalStateException::new);
        }


    }

}
