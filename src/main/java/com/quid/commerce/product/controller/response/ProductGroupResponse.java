package com.quid.commerce.product.controller.response;

import com.quid.commerce.product.domain.ProductGroup;

public record ProductGroupResponse(String code, int childCount) {

    public static ProductGroupResponse of(ProductGroup productGroup) {
        return new ProductGroupResponse(productGroup.getGroupCode(), productGroup.getProductList().size());
    }
}
