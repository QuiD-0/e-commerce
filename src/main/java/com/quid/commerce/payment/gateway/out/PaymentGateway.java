package com.quid.commerce.payment.gateway.out;

import com.quid.commerce.payment.gateway.model.PayCancelRequest;
import com.quid.commerce.payment.gateway.model.PaymentRequest;
import com.quid.commerce.payment.gateway.model.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-gateway", url = "http://130.162.136.116:9000/payment")
public interface PaymentGateway {

    @PostMapping
    PaymentResponse payRequest(@RequestBody PaymentRequest paymentRequest);

    @PostMapping("/cancel")
    void cancelRequest(@RequestBody PayCancelRequest cancelRequest);
}
