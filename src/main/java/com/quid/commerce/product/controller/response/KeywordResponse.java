package com.quid.commerce.product.controller.response;

import com.quid.commerce.product.domain.Keyword;
import java.util.List;

public record KeywordResponse(String keyword, List<String> groupCodeList) {

    public static List<KeywordResponse> of(List<Keyword> keywords) {
        return keywords.stream()
                .map(keyword -> new KeywordResponse(keyword.getKeyword(), keyword.getGroupCodeList()))
                .toList();
    }

    public static List<KeywordResponse> of(Keyword keywords) {
        return List.of(new KeywordResponse(keywords.getKeyword(), keywords.getGroupCodeList()));
    }
}
