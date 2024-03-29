package com.quid.commerce.product.usecase.productGroup;

import com.quid.commerce.product.controller.response.ProductGroupResponse;
import com.quid.commerce.product.domain.ProductGroup;
import com.quid.commerce.product.repository.ProductGroupRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ProductGroupFindUseCase {

    List<ProductGroupResponse> getGroupList();

    List<ProductGroupResponse> searchGroup(String groupCode);

    @Service
    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    class ProductGroupFindUseCaseImpl implements ProductGroupFindUseCase {

        private final ProductGroupRepository productGroupRepository;
        @Override
        public List<ProductGroupResponse> getGroupList() {
            List<ProductGroup> productGroupList = productGroupRepository.getGroupList();
            return productGroupList.stream()
                    .map(ProductGroupResponse::of)
                    .toList();
        }

        @Override
        public List<ProductGroupResponse> searchGroup(String groupCode) {
            List<ProductGroup> groups = productGroupRepository.findGroupByCode(groupCode);
            return ProductGroupResponse.listOf(groups);
        }

    }
}
