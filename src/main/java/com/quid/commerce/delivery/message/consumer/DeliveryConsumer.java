package com.quid.commerce.delivery.message.consumer;

import com.quid.commerce.delivery.usecase.DeliveryCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;


public interface DeliveryConsumer {

    @Component
    @RequiredArgsConstructor
    class KafkaDeliveryConsumer implements DeliveryConsumer {

        private final String TOPIC = "commerce";

        private final DeliveryCreate deliveryCreate;

        @KafkaListener(topics = TOPIC)
        public void deliveryRequest(String request, Acknowledgment ack) {
            deliveryCreate.prepareDelivery(request);
            ack.acknowledge();
        }
    }

}
