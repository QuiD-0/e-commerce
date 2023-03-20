package com.quid.commerce.product.domain;

import java.util.List;
import lombok.Data;

@Data
public class ProductGroup {

    private Long productGroupId;
    private List<Product> productList;
}
