package com.quid.commerce.product.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupCode;

    @OneToMany(mappedBy = "productGroup", cascade = CascadeType.ALL)
    private List<Product> productList;

    private ProductGroup(String groupCode, List<Product> productList) {
        this.groupCode = groupCode;
        this.productList = productList;
    }

    public static ProductGroup create(String productGroupId) {
        return new ProductGroup(productGroupId, new ArrayList<>());
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
}
