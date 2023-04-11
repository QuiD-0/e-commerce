package com.quid.commerce.order.usecase;

import com.quid.commerce.delivery.domain.WayBill;
import com.quid.commerce.delivery.repository.WayBillRepository;
import com.quid.commerce.order.controller.response.OrderInfoResponse;
import com.quid.commerce.order.domain.Order;
import com.quid.commerce.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface OrderInfo {


    OrderInfoResponse getInfo(Long orderId);

    @Service
    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    class OrderInfoUseCase implements OrderInfo {

        private final WayBillRepository wayBillRepository;
        private final OrderRepository orderRepository;

        @Override
        public OrderInfoResponse getInfo(Long orderId) {
            Order order = orderRepository.findOrder(orderId);
            WayBill wayBill = wayBillRepository.findByOrder_Id(orderId).orElse(WayBill.empty());
            return OrderInfoResponse.of(order, wayBill);
        }
    }
}
