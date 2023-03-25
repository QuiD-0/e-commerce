package com.quid.commerce.product.usecase.keyword;

import com.quid.commerce.product.controller.response.KeywordResponse;
import com.quid.commerce.product.domain.Keyword;
import com.quid.commerce.product.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface KeywordFindUseCase {
    List<KeywordResponse> getKeywordList();

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
    }
}
