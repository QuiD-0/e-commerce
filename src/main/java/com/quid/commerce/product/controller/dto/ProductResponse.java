package com.quid.commerce.product.controller.dto;

import com.quid.commerce.product.domain.Product;
import java.util.List;

public record ProductResponse(Long productId, String name, int price) {

    public static List<ProductResponse> of(List<Product> value) {
        return value.stream()
            .map(product -> new ProductResponse(product.getProductId(), product.getName(), product.getPrice()))
            .toList();
    }
}
