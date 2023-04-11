package com.quid.commerce.order.usecase;

import com.quid.commerce.order.domain.Order;
import com.quid.commerce.order.repository.OrderRepository;
import com.quid.commerce.payment.gateway.PaymentGateway;
import com.quid.commerce.payment.gateway.model.PayCancelRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface OrderCancel {

    void cancel(Long orderId);

    @Service
    @Transactional
    @RequiredArgsConstructor
    class OrderCancelUseCase implements OrderCancel {

        private final OrderRepository orderRepository;
        private final PaymentGateway paymentGateway;

        @Override
        public void cancel(Long orderId) {
            Order order = orderRepository.findOrder(orderId);
            order.cancel();

            PayCancelRequest request = PayCancelRequest.of(order.paymentId());
            paymentGateway.cancelRequest(request);
        }
    }

}
