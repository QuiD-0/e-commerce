package com.quid.commerce.delivery.event.producer;

import com.quid.commerce.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

public interface DeliveryProducer {

    void deliveryRequest(Order order);

    @Component
    @RequiredArgsConstructor
    class KafkaDeliveryProducer implements DeliveryProducer {

        private final KafkaTemplate<String, Long> kafkaTemplate;
        //원하는토픽 지정
        private String topic = "commerce";

        @Override
        public void deliveryRequest(Order order) {
            kafkaTemplate.send(topic, order.getOrderNumber(), order.getId());
        }
    }
}
