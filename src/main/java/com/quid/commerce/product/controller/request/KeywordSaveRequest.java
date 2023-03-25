package com.quid.commerce.product.controller.request;

public record KeywordSaveRequest(String keyword, String groupCode) {

    public KeywordSaveRequest {
        if (keyword == null || keyword.isBlank()) {
            throw new IllegalArgumentException("keyword is null or blank");
        }
        if (groupCode == null || groupCode.isBlank()) {
            throw new IllegalArgumentException("groupCode is null or blank");
        }
    }
}
