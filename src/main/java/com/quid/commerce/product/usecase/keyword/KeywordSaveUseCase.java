package com.quid.commerce.product.usecase.keyword;

import com.quid.commerce.product.controller.request.KeywordSaveRequest;
import com.quid.commerce.product.controller.response.KeywordResponse;
import com.quid.commerce.product.domain.Keyword;
import com.quid.commerce.product.domain.ProductGroup;
import com.quid.commerce.product.repository.KeywordRepository;
import com.quid.commerce.product.repository.ProductGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface KeywordSaveUseCase {

    void saveKeyWord(KeywordSaveRequest request);


    @Service
    @Transactional
    @RequiredArgsConstructor
    class KeywordSaveUseCaseImpl implements KeywordSaveUseCase {

        private final ProductGroupRepository productGroupRepository;
        private final KeywordRepository keywordRepository;

        @Override
        public void saveKeyWord(KeywordSaveRequest request) {
            ProductGroup productGroup = productGroupRepository.findByGroupCode(request.groupCode())
                .orElseThrow(() -> new IllegalArgumentException("ProductGroup not found"));

            keywordRepository.findByKeyword(request.keyword())
                .ifPresentOrElse(keyword -> keyword.addProductGroup(productGroup),
                    () -> keywordRepository.save(Keyword.create(request.keyword(), productGroup)));
        }

    }
}