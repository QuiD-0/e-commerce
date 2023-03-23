package com.quid.commerce.product.usecase;

import com.quid.commerce.product.controller.dto.ProductSearchResponse;
import com.quid.commerce.product.domain.Product;
import com.quid.commerce.product.repository.ProductRepository;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ProductFindUseCase {

    Set getSortedProductList(String key);

    List<ProductSearchResponse> searchProduct(String keyword);


    @Service
    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    class ProductFindUseCaseImpl implements ProductFindUseCase {

        private final ProductRepository productRepository;

        @Override
        public Set getSortedProductList(String key) {
            return productRepository.getZsetValue(key);
        }

        @Override
        public List<ProductSearchResponse> searchProduct(String keyword) {
            List<Product> products = productRepository.searchByKeyword(keyword);
            return ProductSearchResponse.listOf(products);
        }
    }

}
