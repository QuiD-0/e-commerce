package com.quid.commerce.product.repository;

import com.quid.commerce.product.domain.Product;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface ProductRepository {

    Set getZsetValue(String key);

    void saveProduct(Product product);

    @Repository
    @RequiredArgsConstructor
    class ProductRepositoryImpl implements ProductRepository {

        private final RedisProductRepository redisProductRepository;

        @Override
        public Set getZsetValue(String key) {
            return redisProductRepository.getZsetValue(key);
        }

        @Override
        public void saveProduct(Product product) {
            redisProductRepository.setZsetValue(product);
        }
    }
}
