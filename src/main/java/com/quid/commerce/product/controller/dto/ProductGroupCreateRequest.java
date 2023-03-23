package com.quid.commerce.product.controller.dto;

public record ProductGroupCreateRequest(String code) {

    public ProductGroupCreateRequest {
        if (code == null) {
            throw new IllegalArgumentException("code must not be null");
        }
    }
}
