package com.quid.commerce.product.usecase;

import com.quid.commerce.product.repository.ProductRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ProductFindUseCase {

    Set getSortedProductList(String key);


    @Service
    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    class ProductFindUseCaseImpl implements ProductFindUseCase {

        private final ProductRepository productRepository;

        @Override
        public Set getSortedProductList(String key) {
            return productRepository.getZsetValue(key);
        }
    }

}
