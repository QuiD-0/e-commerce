package com.quid.commerce.payment.gateway;

import com.quid.commerce.payment.gateway.model.PaymentRequest;
import com.quid.commerce.payment.gateway.model.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-gateway", url = "http://localhost:8081/payment")
public interface PaymentGateway {

    @PostMapping
    PaymentResponse payRequest(@RequestBody PaymentRequest paymentRequest);

}