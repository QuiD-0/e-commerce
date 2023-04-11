package com.quid.commerce.payment.mock;

import com.quid.commerce.payment.gateway.model.PayCancelRequest;
import com.quid.commerce.payment.gateway.model.PaymentRequest;
import com.quid.commerce.payment.gateway.model.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class MockController {

    @PostMapping
    public PaymentResponse payRequest(@RequestBody PaymentRequest paymentRequest) {
        return PaymentResponse.of(paymentRequest);
    }

    @PostMapping("/cancel")
    public void cancelRequest(@RequestBody PayCancelRequest request) {

    }

}
