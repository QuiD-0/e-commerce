package com.quid.commerce.product.controller;

import com.quid.commerce.product.controller.request.KeywordSaveRequest;
import com.quid.commerce.product.controller.response.KeywordResponse;
import com.quid.commerce.product.usecase.keyword.KeywordFindUseCase;
import com.quid.commerce.product.usecase.keyword.KeywordSaveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/keyword")
public class KeywordController {

    private final KeywordSaveUseCase keywordSaveUseCase;
    private final KeywordFindUseCase keywordFindUseCase;

    @PostMapping
    public void saveKeyWord(@RequestBody KeywordSaveRequest request) {
        keywordSaveUseCase.saveKeyWord(request);
    }

    @GetMapping("/list")
    public List<KeywordResponse> getKeywordList() {
        return keywordFindUseCase.getKeywordList();
    }
}
