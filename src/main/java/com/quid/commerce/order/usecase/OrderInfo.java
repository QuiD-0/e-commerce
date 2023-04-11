package com.quid.commerce.order.usecase;

import com.quid.commerce.order.controller.response.OrderInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface OrderInfo {


    OrderInfoResponse getInfo(Long orderId);

    @Service
    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    class OrderInfoUseCase implements OrderInfo {

        @Override
        public OrderInfoResponse getInfo(Long orderId) {
            return null;
        }
    }
}
