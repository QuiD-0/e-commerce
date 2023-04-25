package com.quid.commerce.config.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class BearerTokenRequestInterceptor implements RequestInterceptor {

    private final String accessToken;

    public BearerTokenRequestInterceptor(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + accessToken);
    }
}