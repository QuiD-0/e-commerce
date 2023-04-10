package com.quid.commerce.delivery.message.producer;

import com.quid.commerce.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

public interface DeliveryProducer {

    void deliveryRequest(Order order);

    @Component
    @RequiredArgsConstructor
    class KafkaDeliveryProducer implements DeliveryProducer {

        private final KafkaTemplate<Long, String> kafkaTemplate;
        private final String TOPIC = "commerce";

        @Override
        public void deliveryRequest(Order order) {
            kafkaTemplate.send(TOPIC, order.getId(), order.getOrderNumber());
        }
    }
}
