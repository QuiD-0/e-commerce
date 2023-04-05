package com.quid.commerce.product.repository;

import com.quid.commerce.product.domain.Product;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class FakeProductRepository implements ProductRepository{

    @Override
    public Set getZsetValue(String key) {
        return null;
    }

    @Override
    public void saveProduct(Product product) {

    }

    @Override
    public Optional<Product> findById(Long productId) {
        return Optional.empty();
    }

    @Override
    public void deleteProduct(Product product) {

    }

    @Override
    public List<Product> searchByKeyword(String keyword) {
        return null;
    }
}
