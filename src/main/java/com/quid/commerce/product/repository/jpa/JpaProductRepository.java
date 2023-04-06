package com.quid.commerce.product.repository.jpa;

import com.quid.commerce.product.domain.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContaining(String keyword);

    List<Product> findByIdIn(List<Long> keySet);
}
