package com.quid.commerce.product.domain;

import javax.persistence.CascadeType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProductGroup productGroup;
    private Integer stock;

    private Product(String name, int price, ProductGroup productGroup, Integer stock) {
        this.name = name;
        this.price = price;
        this.productGroup = productGroup;
        this.stock = stock;
    }

    public static Product create(String name, Integer price, ProductGroup productGroup, Integer stock) {
        Product product = new Product(name, price, productGroup, stock);
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

    public void decreaseStock() {
        this.stock--;
    }

    public void increaseStock() {
        this.stock++;
    }
}
