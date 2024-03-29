package com.quid.commerce.product.controller.response;

import com.quid.commerce.product.domain.Product;
import java.util.List;

public record ProductResponse(Long productId, String name, int price) {

    public static List<ProductResponse> of(List<Product> value) {
        return value.stream()
            .map(product -> new ProductResponse(product.getId(), product.getName(), product.getPrice()))
            .toList();
    }
}
