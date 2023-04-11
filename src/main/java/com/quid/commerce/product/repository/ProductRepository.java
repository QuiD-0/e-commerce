package com.quid.commerce.product.repository;

import com.quid.commerce.product.domain.Product;
import com.quid.commerce.product.repository.jpa.JpaProductRepository;
import com.quid.commerce.product.repository.redis.RedisProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface ProductRepository {

    Set getZsetValue(String key);

    void saveProduct(Product product);

    Optional<Product> findById(Long productId);

    void deleteProduct(Product product);

    List<Product> searchByKeyword(String keyword);

    List<Product> findProductsByIds(List<Long> keySet);

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

        @Override
        public Optional<Product> findById(Long productId) {
            return jpaProductRepository.findById(productId);
        }

        @Override
        public void deleteProduct(Product product) {
            jpaProductRepository.delete(product);
            redisProductRepository.deleteZsetValue(product);
        }

        @Override
        public List<Product> searchByKeyword(String keyword) {
            return jpaProductRepository.findByNameContaining(keyword);
        }

        @Override
        public List<Product> findProductsByIds(List<Long> keySet) {
            return keySet.stream()
                .map(jpaProductRepository::findById)
                .map(product -> product.orElseThrow(
                    () -> new IllegalArgumentException("Product not found")))
                .toList();
        }
    }
}
