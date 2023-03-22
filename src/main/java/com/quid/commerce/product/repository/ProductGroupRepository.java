package com.quid.commerce.product.repository;

import com.quid.commerce.product.domain.ProductGroup;
import com.quid.commerce.product.repository.jpa.JpaProductGroupRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface ProductGroupRepository {

    ProductGroup save(ProductGroup productGroup);

    Optional<ProductGroup> findByGroupCode(String groupCode);

    @Repository
    @RequiredArgsConstructor
    class ProductGroupRepositoryImpl implements ProductGroupRepository {
        private final JpaProductGroupRepository jpaProductGroupRepository;

        @Override
        public ProductGroup save(ProductGroup productGroup) {
            return jpaProductGroupRepository.save(productGroup);
        }

        @Override
        public Optional<ProductGroup> findByGroupCode(String groupCode) {
            return jpaProductGroupRepository.findByGroupCode(groupCode);
        }

    }
}
