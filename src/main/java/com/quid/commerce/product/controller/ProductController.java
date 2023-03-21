package com.quid.commerce.product.controller;

import com.quid.commerce.product.controller.dto.ProductCreateRequest;
import com.quid.commerce.product.usecase.ProductFindUseCase;
import com.quid.commerce.product.usecase.ProductSaveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductFindUseCase productFindUseCase;
    private final ProductSaveUseCase productSaveUseCase;

    @GetMapping
    public Object getZsetValue(String key) {
        return productFindUseCase.getSortedProductList(key);
    }

    @PostMapping
    public void setZsetValue(@RequestBody ProductCreateRequest request) {
        productSaveUseCase.createProduct(request.toProduct());
    }

}
