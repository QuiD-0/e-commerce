package com.quid.commerce.product.controller.dto;

import com.quid.commerce.product.domain.Product;
import com.quid.commerce.product.domain.ProductGroup;
import java.util.ArrayList;

public record ProductCreateRequest(Long productId, String name, int price) {

    public Product toProduct() {
        return Product.create(productId, name, price);
    }
}
