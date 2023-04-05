package com.quid.commerce.product.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProductGroup productGroup;

    private Product(String name, int price, ProductGroup productGroup) {
        this.name = name;
        this.price = price;
        this.productGroup = productGroup;
    }

    public static Product create(String name, int price, ProductGroup productGroup) {
        Product product = new Product(name, price, productGroup);
        productGroup.addProduct(product);
        return product;
    }

    public String getGroupCode() {
        return productGroup.getGroupCode();
    }

    public void updatePrice(int price) {
        this.price = price;
    }

    public String getProductGroupCode() {
        return productGroup.getGroupCode();
    }
}
