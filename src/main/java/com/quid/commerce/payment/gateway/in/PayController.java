package com.quid.commerce.payment.gateway.in;

import com.quid.commerce.payment.gateway.model.PayRequest;
import com.quid.commerce.payment.usecase.OrderPay;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pay")
public class PayController {

    private final OrderPay orderPay;

    @PostMapping
    public void payOrder(@RequestBody PayRequest orderId) {
        orderPay.request(orderId.orderId());
    }
}
