package com.quid.commerce.order.controller;

import com.quid.commerce.order.controller.request.OrderCreateRequest;
import com.quid.commerce.order.usecase.OrderCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderCreate orderCreate;

    @PostMapping
    public void createOrder(OrderCreateRequest request) {
        orderCreate.create(request);
    }

}
