package com.quid.commerce.product.repository;

import com.quid.commerce.product.domain.Product;
import com.quid.commerce.product.repository.jpa.JpaProductRepository;
import com.quid.commerce.product.repository.redis.RedisProductRepository;
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
        private final JpaProductRepository jpaProductRepository;

        @Override
        public Set getZsetValue(String key) {
            return redisProductRepository.getZsetValue(key);
        }

        @Override
        public void saveProduct(Product product) {
            Product savedProduct = jpaProductRepository.save(product);
            redisProductRepository.setZsetValue(savedProduct);
        }
    }
}
