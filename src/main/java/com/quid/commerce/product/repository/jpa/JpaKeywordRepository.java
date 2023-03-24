package com.quid.commerce.product.repository.jpa;

import com.quid.commerce.product.domain.Keyword;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaKeywordRepository extends JpaRepository<Keyword, Long> {

    Optional<Keyword> findByKeyword(String keyword);
}
