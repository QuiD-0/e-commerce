package com.quid.commerce.order.controller;

import com.quid.commerce.order.controller.request.OrderCreateRequest;
import com.quid.commerce.order.usecase.OrderCreate;
import com.quid.commerce.order.usecase.OrderPay;
import lombok.RequiredArgsConstructor;
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

    @PostMapping
    public void createOrder(@RequestBody OrderCreateRequest request) {
        orderCreate.create(request);
    }

    @PostMapping("/pay")
    public void payOrder(@RequestBody Long orderId) {
        orderPay.request(orderId);
    }

}
