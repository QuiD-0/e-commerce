package com.quid.commerce.product.usecase.product;

import com.quid.commerce.product.controller.request.UpdateProductPriceRequest;
import com.quid.commerce.product.domain.Product;
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
            Product product = productRepository.findById(request.productId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
            product.updatePrice(request.price());

            productRepository.saveProduct(product);
        }

    }
}
