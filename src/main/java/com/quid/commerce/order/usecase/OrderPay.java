package com.quid.commerce.order.usecase;

import com.quid.commerce.delivery.message.producer.DeliveryProducer;
import com.quid.commerce.order.domain.Order;
import com.quid.commerce.order.repository.OrderRepository;
import com.quid.commerce.payment.gateway.PaymentGateway;
import com.quid.commerce.payment.gateway.model.PaymentRequest;
import com.quid.commerce.payment.gateway.model.PaymentResponse;
import com.quid.commerce.product.repository.ProductRepository;
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
        private final ProductRepository productRepository;

        @Override
        public void request(Long orderId) {
            Order order = orderRepository.findOrder(orderId);
            order.validatePayable();

            PaymentResponse paymentResponse = paymentGateway.payRequest(PaymentRequest.of(order));
            orderRepository.pay(order, paymentResponse);

            if(order.isPayed()){
                deliveryProducer.deliveryRequest(order);
            }else {
                productRepository.rollbackStock(order);
            }
        }
    }

}
