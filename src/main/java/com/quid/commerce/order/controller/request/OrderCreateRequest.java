package com.quid.commerce.order.controller.request;

import com.quid.commerce.order.domain.OrdererInfo;
import java.util.Map;

public record OrderCreateRequest(Map<Long, Integer> productMap, OrdererInfo ordererInfo) {

    public OrderCreateRequest {
        if (productMap == null || productMap.isEmpty()) {
            throw new IllegalArgumentException("상품이 존재하지 않습니다.");
        }
        if (ordererInfo == null) {
            throw new IllegalArgumentException("주문자 정보가 존재하지 않습니다.");
        }
    }
}
