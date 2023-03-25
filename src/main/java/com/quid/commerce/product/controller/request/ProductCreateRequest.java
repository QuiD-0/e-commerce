package com.quid.commerce.product.controller.request;

public record ProductCreateRequest(String name, int price, String groupCode) {

    public ProductCreateRequest {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if (groupCode == null) {
            throw new IllegalArgumentException("groupCode must not be null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price must be greater than or equal to 0");
        }
    }
}
