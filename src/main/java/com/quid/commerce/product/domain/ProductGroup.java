package com.quid.commerce.product.domain;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productGroupId;

    @OneToMany(mappedBy = "productGroup", cascade = CascadeType.ALL)
    private List<Product> productList;

    private ProductGroup(String productGroupId, List<Product> productList) {
        this.productGroupId = productGroupId;
        this.productList = productList;
    }

    public static ProductGroup create(String productGroupId, List<Product> productList) {
        return new ProductGroup(productGroupId, productList);
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
}
