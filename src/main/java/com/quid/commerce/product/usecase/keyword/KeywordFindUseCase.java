package com.quid.commerce.product.usecase.keyword;

import com.quid.commerce.product.controller.response.KeywordResponse;
import com.quid.commerce.product.domain.Keyword;
import com.quid.commerce.product.repository.KeywordRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface KeywordFindUseCase {

    List<KeywordResponse> getKeywordList();

    List<KeywordResponse> searchKeyword(String keyword);

    @Service
    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    class KeywordFindUseCaseImpl implements KeywordFindUseCase {

        private final KeywordRepository keywordRepository;

        @Override
        public List<KeywordResponse> getKeywordList() {
            List<Keyword> keywords = keywordRepository.findAll();
            return KeywordResponse.of(keywords);
        }

        @Override
        public List<KeywordResponse> searchKeyword(String keyword) {
            Keyword keywords = keywordRepository.findByKeyword(keyword)
                .orElseThrow(() -> new IllegalArgumentException("Keyword not found"));
            return KeywordResponse.of(keywords);
        }
    }
}
