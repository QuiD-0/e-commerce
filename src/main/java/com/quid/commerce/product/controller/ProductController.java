package com.quid.commerce.product.controller;

import com.quid.commerce.product.usecase.ProductFindUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductFindUseCase productFindUseCase;

    @GetMapping("/zset")
    public Object getZsetValue(String key) {
        return productFindUseCase.getZsetValue(key);
    }

}
