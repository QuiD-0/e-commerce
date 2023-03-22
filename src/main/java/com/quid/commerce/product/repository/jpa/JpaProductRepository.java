package com.quid.commerce.product.repository.jpa;

import com.quid.commerce.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<Product, Long> {
}
