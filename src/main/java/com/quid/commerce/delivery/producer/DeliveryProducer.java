package com.quid.commerce.delivery.producer;

import com.quid.commerce.order.domain.Order;

public interface DeliveryProducer {

    void deliveryRequest(Order order);

    class KafkaDeliveryProducer implements DeliveryProducer {

        @Override
        public void deliveryRequest(Order order) {

        }
    }
}
