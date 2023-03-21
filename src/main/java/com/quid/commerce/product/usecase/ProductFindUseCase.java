package com.quid.commerce.product.usecase;

import com.quid.commerce.product.repository.ProductRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface ProductFindUseCase {

    Set getZsetValue(String key);


    @Service
    @RequiredArgsConstructor
    class ProductFindUseCaseImpl implements ProductFindUseCase {

        private final ProductRepository productRepository;

        @Override
        public Set getZsetValue(String key) {
            return productRepository.getZsetValue(key);
        }
    }

}
