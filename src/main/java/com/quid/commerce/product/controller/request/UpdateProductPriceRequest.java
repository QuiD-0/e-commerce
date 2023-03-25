package com.quid.commerce.product.controller.request;

public record UpdateProductPriceRequest(Long productId, int price) {

    public UpdateProductPriceRequest {
        if (productId == null) {
            throw new IllegalArgumentException("productId must not be null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price must be greater than or equal to 0");
        }
    }

}
