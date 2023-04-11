package com.quid.commerce.order.domain.validate;

import com.quid.commerce.order.domain.Order;
import com.quid.commerce.order.domain.OrderStatus;
import com.quid.commerce.order.domain.PayStatus;
import java.time.LocalDateTime;

public class OrderCancelPipe{

    public static void check(Order order) {
        Pipe.of(OrderCancelPipe::checkOrderStatus)
                .addPipe(OrderCancelPipe::checkThreeDaysPassed)
                .addPipe(OrderCancelPipe::checkPaymentStatus)
                .execute(order);
    }

    private static Order checkPaymentStatus(Order order) {
        if (order.getPaymentInfo().getPayStatus() != PayStatus.PAYMENT_COMPLETED) {
            throw new IllegalStateException("결제가 완료되지 않은 주문은 취소할 수 없습니다.");
        }
        return order;
    }

    private static Order checkThreeDaysPassed(Order order) {
        if (order.getCreatedAt().plusDays(3).isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("주문 취소는 결제 후 3일 이내에만 가능합니다.");
        }
        return order;
    }

    private static Order checkOrderStatus(Order order) {
        if (order.getOrderStatus() == OrderStatus.CANCELLED) {
            throw new IllegalStateException("이미 취소된 주문입니다.");
        }
        return order;
    }

}
