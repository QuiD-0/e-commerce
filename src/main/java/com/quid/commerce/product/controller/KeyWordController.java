package com.quid.commerce.product.controller;

import com.quid.commerce.product.controller.dto.KeywordSaveRequest;
import com.quid.commerce.product.usecase.keyword.KeywordSaveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/keyword")
public class KeyWordController {

    private final KeywordSaveUseCase keywordFindUseCase;

    @PostMapping
    public void saveKeyWord(@RequestBody KeywordSaveRequest request) {
        keywordFindUseCase.saveKeyWord(request);
    }
}
