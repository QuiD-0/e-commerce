package com.quid.commerce.product.domain;

import java.util.List;
import lombok.Getter;

@Getter
public class ProductGroup {

    private String productGroupId;
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
