package com.quid.commerce.product.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private int price;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProductGroup productGroup;

    private Product(Long productId, String name, int price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public static Product create(Long productId, String name, int price) {
        return new Product(productId, name, price);
    }

    public String getProductGroupId() {
        return productGroup.getProductGroupId();
    }
}
