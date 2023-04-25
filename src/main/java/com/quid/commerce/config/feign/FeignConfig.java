package com.quid.commerce.config.feign;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.quid.commerce")
public class FeignConfig {

    @Value("${quid.payment.gateway.access-token}")
    private String accessToken;

    @Bean
    public RequestInterceptor bearerTokenRequestInterceptor() {
        return new BearerTokenRequestInterceptor(accessToken);
    }
}
