package com.quid.commerce.order.repository;

import com.quid.commerce.order.repository.jpa.JpaOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface OrderRepository {

    @Repository
    @RequiredArgsConstructor
    class OrderRepositoryImpl implements OrderRepository {
        private final JpaOrderRepository jpaOrderRepository;

    }

}
