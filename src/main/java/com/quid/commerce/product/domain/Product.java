package com.quid.commerce.product.domain;

import lombok.Data;

@Data
public class Product {

    private Long productId;
    private String name;
    private int price;
    private ProductGroup productGroup;
}
