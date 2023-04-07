package com.quid.commerce.mock;

import com.quid.commerce.payment.gateway.model.PaymentRequest;
import com.quid.commerce.payment.gateway.model.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MockController {

    @PostMapping("/payment")
    public PaymentResponse payRequest(@RequestBody PaymentRequest paymentRequest) {
        return PaymentResponse.of(paymentRequest);
    }

}
