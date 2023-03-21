package com.quid.commerce.product.repository;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface ProductRepository {

    Set getZsetValue(String key);

    @Repository
    @RequiredArgsConstructor
    class ProductRepositoryImpl implements ProductRepository {

        private final RedisProductRepository redisProductRepository;

        @Override
        public Set getZsetValue(String key) {
            return redisProductRepository.getZsetValue(key);
        }
    }
}
