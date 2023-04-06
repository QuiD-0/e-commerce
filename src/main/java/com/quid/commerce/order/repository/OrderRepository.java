package com.quid.commerce.order.repository;

import com.quid.commerce.order.domain.Order;
import com.quid.commerce.order.repository.jpa.JpaOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface OrderRepository {

    Order save(Order order);

    @Repository
    @RequiredArgsConstructor
    class OrderRepositoryImpl implements OrderRepository {
        private final JpaOrderRepository jpaOrderRepository;

        @Override
        public Order save(Order order) {
            return jpaOrderRepository.save(order);
        }
    }

}
