package com.quid.commerce.order.controller;

import com.quid.commerce.order.controller.request.OrderCreateRequest;
import com.quid.commerce.order.controller.request.OrderPayRequest;
import com.quid.commerce.order.controller.response.OrderInfoResponse;
import com.quid.commerce.order.usecase.OrderCreate;
import com.quid.commerce.order.usecase.OrderInfo;
import com.quid.commerce.order.usecase.OrderPay;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderCreate orderCreate;
    private final OrderPay orderPay;
    private final OrderInfo orderInfo;

    @PostMapping
    public void createOrder(@RequestBody OrderCreateRequest request) {
        orderCreate.create(request);
    }

    @PostMapping("/pay")
    public void payOrder(@RequestBody OrderPayRequest orderId) {
        orderPay.request(orderId.orderId());
    }

    @PostMapping("/cancel")
    public void cancelOrder(@RequestBody OrderPayRequest orderId) {
        orderPay.request(orderId.orderId());
    }

    @GetMapping("/info/{orderId}")
    public OrderInfoResponse getOrderInfo(@PathVariable Long orderId) {
        return orderInfo.getInfo(orderId);
    }

}
