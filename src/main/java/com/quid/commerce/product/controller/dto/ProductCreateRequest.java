package com.quid.commerce.product.controller.dto;

public record ProductCreateRequest(Long productId, String name, int price, String groupCode) {

}
