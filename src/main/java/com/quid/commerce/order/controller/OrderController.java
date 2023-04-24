package com.quid.commerce.order.controller;

import com.quid.commerce.order.controller.request.OrderCreateRequest;
import com.quid.commerce.payment.gateway.model.PayRequest;
import com.quid.commerce.order.controller.response.OrderInfoResponse;
import com.quid.commerce.order.usecase.OrderCancel;
import com.quid.commerce.order.usecase.OrderCreate;
import com.quid.commerce.order.usecase.OrderInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderCreate orderCreate;
    private final OrderCancel orderCancel;
    private final OrderInfo orderInfo;

    @PostMapping
    public void createOrder(@RequestBody OrderCreateRequest request) {
        orderCreate.create(request);
    }

    @PostMapping("/cancel")
    public void cancelOrder(@RequestBody PayRequest orderId) {
        orderCancel.cancel(orderId.orderId());
    }

    @GetMapping("/info/{orderId}")
    public OrderInfoResponse getOrderInfo(@PathVariable Long orderId) {
        return orderInfo.getInfo(orderId);
    }

    @GetMapping("/list/{ordererName}")
    public List<OrderInfoResponse> getOrderList(@PathVariable String ordererName) {
        return orderInfo.getInfo(ordererName);
    }

}
