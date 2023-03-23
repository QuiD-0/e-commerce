package com.quid.commerce.product.usecase;

import com.quid.commerce.product.controller.dto.ProductGroupCreateRequest;
import com.quid.commerce.product.domain.ProductGroup;
import com.quid.commerce.product.repository.ProductGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ProductGroupSaveUseCase {

    void createProductGroup(ProductGroupCreateRequest request);

    @Service
    @Transactional
    @RequiredArgsConstructor
    class ProductGroupSaveUseCaseImpl implements ProductGroupSaveUseCase {

        private final ProductGroupRepository productGroupRepository;

        @Override
        public void createProductGroup(ProductGroupCreateRequest request) {
            productGroupRepository.save(ProductGroup.create(request.code()));
        }

    }
}
