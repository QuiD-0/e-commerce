package com.quid.commerce.order.usecase;

import com.quid.commerce.delivery.message.producer.DeliveryProducer;
import com.quid.commerce.order.domain.Order;
import com.quid.commerce.order.repository.OrderRepository;
import com.quid.commerce.payment.gateway.model.PaymentRequest;
import com.quid.commerce.payment.gateway.model.PaymentResponse;
import com.quid.commerce.payment.gateway.out.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface OrderPay {

    void request(Long orderId);

    @Service
    @Transactional
    @RequiredArgsConstructor
    class OrderPayUseCase implements OrderPay {

        private final PaymentGateway paymentGateway;
        private final DeliveryProducer deliveryProducer;
        private final OrderRepository orderRepository;

        @Override
        public void request(Long orderId) {
            Order order = orderRepository.findOrder(orderId);
            PaymentResponse paymentResponse = paymentGateway.payRequest(PaymentRequest.of(order));

            order.pay(paymentResponse);

            if(paymentResponse.payComplete()){
                deliveryProducer.deliveryRequest(order);
            }

            orderRepository.save(order);
        }
    }

}
