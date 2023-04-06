package com.quid.commerce.order.usecase;

import com.quid.commerce.delivery.kafka.DeliveryProducer;
import com.quid.commerce.order.domain.Order;
import com.quid.commerce.order.repository.OrderRepository;
import com.quid.commerce.payment.gateway.PaymentGateway;
import com.quid.commerce.payment.gateway.model.PaymentRequest;
import com.quid.commerce.payment.gateway.model.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface OrderPay {

    void request(Long orderId);

    @Service
    @Transactional
    @RequiredArgsConstructor
    class OrderPayImpl implements OrderPay {

        private final OrderRepository orderRepository;
        private final PaymentGateway paymentGateway;
        private final DeliveryProducer deliveryProducer;

        @Override
        public void request(Long orderId) {
            Order order = orderRepository.findOrder(orderId);
            order.validatePayable();

            PaymentResponse paymentResponse = paymentGateway.payRequest(PaymentRequest.of(order));
            orderRepository.pay(order, paymentResponse);
            if(order.isPayed()){
                deliveryProducer.deliveryRequest(order);
            }
        }
    }

}
