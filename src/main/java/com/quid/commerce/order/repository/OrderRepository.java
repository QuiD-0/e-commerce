package com.quid.commerce.order.repository;

import com.quid.commerce.order.domain.Order;
import com.quid.commerce.order.repository.jpa.JpaOrderRepository;
import com.quid.commerce.payment.gateway.model.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface OrderRepository {

    Order save(Order order);

    Order findOrder(Long orderId);

    void pay(Order orderId, PaymentResponse paymentResponse);

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
        public void pay(Order order, PaymentResponse paymentResponse) {
            order.pay(paymentResponse);
            jpaOrderRepository.save(order);
        }
    }

}
