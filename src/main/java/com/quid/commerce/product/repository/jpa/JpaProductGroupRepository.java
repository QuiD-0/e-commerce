package com.quid.commerce.product.repository.jpa;

import com.quid.commerce.product.domain.ProductGroup;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductGroupRepository extends JpaRepository<ProductGroup, Long> {

    Optional<ProductGroup> findByGroupCode(String groupCode);
}
