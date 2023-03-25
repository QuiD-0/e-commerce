package com.quid.commerce.product.controller.response;

import static java.util.stream.Collectors.groupingBy;

import com.quid.commerce.product.domain.Product;
import java.util.List;
import java.util.Map.Entry;

public record ProductSearchResponse(String productGroupCode, List<ProductResponse> products) {

    public static List<ProductSearchResponse> listOf(List<Product> products) {
        return products.stream()
            .collect(groupingBy(Product::getProductGroupCode))
            .entrySet()
            .stream()
            .map(ProductSearchResponse::of)
            .toList();
    }

    private static ProductSearchResponse of(Entry<String, List<Product>> entry) {
        return new ProductSearchResponse(entry.getKey(), ProductResponse.of(entry.getValue()));
    }
}
