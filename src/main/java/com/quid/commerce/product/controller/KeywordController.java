package com.quid.commerce.product.controller;

import com.quid.commerce.product.controller.request.KeywordSaveRequest;
import com.quid.commerce.product.controller.response.KeywordResponse;
import com.quid.commerce.product.usecase.keyword.KeywordFindUseCase;
import com.quid.commerce.product.usecase.keyword.KeywordSaveUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/search/{keyword}")
    public List<KeywordResponse> searchKeyword(@PathVariable(name = "keyword") String keyword) {
        return keywordFindUseCase.searchKeyword(keyword);
    }
}
