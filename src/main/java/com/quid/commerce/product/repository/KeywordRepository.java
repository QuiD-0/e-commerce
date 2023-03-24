package com.quid.commerce.product.repository;

import com.quid.commerce.product.domain.Keyword;
import com.quid.commerce.product.repository.jpa.JpaKeywordRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface KeywordRepository {

    Optional<Keyword> findByKeyword(String keyword);

    Keyword save(Keyword keyword);

    @Repository
    @RequiredArgsConstructor
    class KeywordRepositoryImpl implements KeywordRepository {

        private final JpaKeywordRepository jpaKeywordRepository;

        @Override
        public Optional<Keyword> findByKeyword(String keyword) {
            return jpaKeywordRepository.findByKeyword(keyword);
        }

        @Override
        public Keyword save(Keyword keyword) {
            return jpaKeywordRepository.save(keyword);
        }
    }
}
