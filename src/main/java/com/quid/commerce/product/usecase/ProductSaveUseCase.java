package com.quid.commerce.product.usecase;

import com.quid.commerce.product.controller.dto.ProductCreateRequest;
import com.quid.commerce.product.domain.Product;
import com.quid.commerce.product.domain.ProductGroup;
import com.quid.commerce.product.repository.ProductGroupRepository;
import com.quid.commerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ProductSaveUseCase {

    void createProduct(ProductCreateRequest request);

    @Service
    @Transactional
    @RequiredArgsConstructor
    class ProductSaveUseCaseImpl implements ProductSaveUseCase {

        private final ProductRepository productRepository;
        private final ProductGroupRepository productGroupRepository;

        @Override
        public void createProduct(ProductCreateRequest request) {
            ProductGroup productGroup = productGroupRepository.findByGroupCode(request.groupCode())
                    .orElseThrow(() -> new IllegalArgumentException("ProductGroup not found"));

            Product product = Product.create(request.name(),request.price(), productGroup);
            productRepository.saveProduct(product);
        }

    }
}
