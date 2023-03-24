package com.quid.commerce.product.usecase.product;

import com.quid.commerce.product.domain.Product;
import com.quid.commerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ProductDeleteUseCase {

    void deleteProduct(Long id);

    @Service
    @Transactional
    @RequiredArgsConstructor
    class ProductDeleteUseCaseImpl implements ProductDeleteUseCase {

        private final ProductRepository productRepository;

        @Override
        public void deleteProduct(Long id) {
            Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
            productRepository.deleteProduct(product);
        }

    }

}
