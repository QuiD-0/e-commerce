package com.quid.commerce.product.usecase;

import com.quid.commerce.product.controller.dto.UpdateProductPriceRequest;
import com.quid.commerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ProductUpdateUseCase {

    void updateProduct(UpdateProductPriceRequest request);

    @Service
    @Transactional
    @RequiredArgsConstructor
    class ProductUpdateUseCaseImpl implements ProductUpdateUseCase {

        private final ProductRepository productRepository;

        @Override
        public void updateProduct(UpdateProductPriceRequest request) {
            productRepository.updateProductPrice(request.productId(), request.price());
        }

    }
}
