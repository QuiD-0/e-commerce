package com.quid.commerce.product.repository;

import com.quid.commerce.product.controller.response.KeywordResponse;
import com.quid.commerce.product.domain.Keyword;
import com.quid.commerce.product.repository.jpa.JpaKeywordRepository;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface KeywordRepository {

    Optional<Keyword> findByKeyword(String keyword);

    Keyword save(Keyword keyword);

    List<Keyword> findAll();

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

        @Override
        public List<Keyword> findAll() {
            return jpaKeywordRepository.findAll();
        }
    }
}
