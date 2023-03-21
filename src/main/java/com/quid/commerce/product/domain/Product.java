package com.quid.commerce.product.domain;

import lombok.Getter;

@Getter
public class Product {

    private Long productId;
    private String name;
    private int price;
    private ProductGroup productGroup;

    private Product(Long productId, String name, int price, ProductGroup productGroup) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.productGroup = productGroup;
    }

    public static Product create(Long productId, String name, int price, ProductGroup productGroup) {
        return new Product(productId, name, price, productGroup);
    }

    public String getProductGroupId() {
        return productGroup.getProductGroupId();
    }
}
