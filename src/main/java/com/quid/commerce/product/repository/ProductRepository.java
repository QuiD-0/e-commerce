package com.quid.commerce.product.repository;

import com.quid.commerce.product.controller.dto.SortedProductResponse;
import com.quid.commerce.product.domain.Product;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface ProductRepository {

    Set<SortedProductResponse> getZsetValue(String key);

    void saveProduct(Product product);

    @Repository
    @RequiredArgsConstructor
    class ProductRepositoryImpl implements ProductRepository {

        private final RedisProductRepository redisProductRepository;
        private final JpaProductRepository jpaProductRepository;

        @Override
        public Set<SortedProductResponse> getZsetValue(String key) {
            return redisProductRepository.getZsetValue(key, SortedProductResponse.class);
        }

        @Override
        public void saveProduct(Product product) {
            redisProductRepository.setZsetValue(product);
            jpaProductRepository.save(product);
        }
    }
}
