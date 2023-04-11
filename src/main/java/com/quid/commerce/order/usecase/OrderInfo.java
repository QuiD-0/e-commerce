package com.quid.commerce.order.usecase;

import com.quid.commerce.delivery.domain.WayBill;
import com.quid.commerce.delivery.repository.WayBillRepository;
import com.quid.commerce.order.controller.response.OrderInfoResponse;
import com.quid.commerce.order.domain.Order;
import com.quid.commerce.order.repository.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface OrderInfo {


    OrderInfoResponse getInfo(Long orderId);

    List<OrderInfoResponse> getInfo(String ordererName);

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

        public List<OrderInfoResponse> getInfo(String ordererName) {
            List<Order> orders = orderRepository.findByOrderer(ordererName);
            List<WayBill> wayBills = wayBillRepository.findByOrder_OrdererInfo_Name(ordererName);

            return orders.stream()
                .map(order -> {
                    WayBill wayBill = findSameOrder(wayBills, order);
                    return OrderInfoResponse.of(order, wayBill);
                })
                .toList();
        }

        private WayBill findSameOrder(List<WayBill> wayBills, Order order) {
            return wayBills.stream()
                .filter(wayBill -> wayBill.getOrder().equals(order))
                .findFirst()
                .orElse(WayBill.empty());
        }

    }
}
