package com.quid.commerce.delivery.usecase;

import com.quid.commerce.delivery.domain.Receiver;
import com.quid.commerce.delivery.domain.Sender;
import com.quid.commerce.delivery.domain.WayBill;
import com.quid.commerce.delivery.repository.WayBillRepository;
import com.quid.commerce.order.domain.Order;
import com.quid.commerce.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface DeliveryCreate {

    void prepareDelivery(String request);

    @Service
    @Transactional
    @RequiredArgsConstructor
    class DeliveryCreateImpl implements DeliveryCreate {

        private final OrderRepository orderRepository;
        private final WayBillRepository wayBillRepository;
        @Override
        public void prepareDelivery(String orderNumber) {
            checkDelivery(orderNumber);

            Order order = orderRepository.findOrder(orderNumber);
            Sender sender = Sender.openMarket();
            Receiver receiver = Receiver.of(order.getOrdererInfo());

            WayBill wayBill = WayBill.publish(sender, receiver, "경기도 용인시", "문앞에 두고 가주세요", order);
            wayBillRepository.save(wayBill);
        }

        private void checkDelivery(String orderNumber) {
            Order order = orderRepository.findOrder(orderNumber);
            wayBillRepository.findByOrder_Id(order.getId()).ifPresent(wayBill -> {
                throw new IllegalStateException("이미 배송중입니다.");
            });
        }
    }

}
