package com.quid.commerce.product.domain;

import java.util.List;
import lombok.Data;

@Data
public class Keyword {
    private String keyword;
    private List<ProductGroup> productGroupList;
}
