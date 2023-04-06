package com.quid.commerce.order.controller.request;

import com.quid.commerce.order.domain.OrdererInfo;
import java.util.List;

public record OrderCreateRequest(List<Long> productIds, OrdererInfo ordererInfo) {

    public OrderCreateRequest {
        if (productIds == null) {
            throw new IllegalArgumentException("상품이 존재하지 않습니다.");
        }
        if (ordererInfo == null) {
            throw new IllegalArgumentException("주문자 정보가 존재하지 않습니다.");
        }
    }
}
