package com.quid.commerce.product.usecase;

import com.quid.commerce.product.domain.Product;
import com.quid.commerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface ProductSaveUseCase {

    void createProduct(Product product);

    @Service
    @RequiredArgsConstructor
    class ProductSaveUseCaseImpl implements ProductSaveUseCase {

        private final ProductRepository productRepository;

        @Override
        public void createProduct(Product product) {
            productRepository.saveProduct(product);
        }

    }
}
