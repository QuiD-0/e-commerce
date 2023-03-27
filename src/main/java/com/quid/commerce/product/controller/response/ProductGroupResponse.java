package com.quid.commerce.product.controller.response;

import com.quid.commerce.product.domain.ProductGroup;
import java.util.List;

public record ProductGroupResponse(String code, int childCount) {

    public static ProductGroupResponse of(ProductGroup productGroup) {
        return new ProductGroupResponse(productGroup.getGroupCode(), productGroup.getProductList().size());
    }

    public static List<ProductGroupResponse> listOf(List<ProductGroup> groups) {
        return groups.stream()
                .map(ProductGroupResponse::of)
                .toList();
    }
}
