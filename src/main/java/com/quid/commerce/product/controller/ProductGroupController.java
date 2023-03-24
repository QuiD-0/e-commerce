package com.quid.commerce.product.controller;

import com.quid.commerce.product.controller.dto.ProductGroupCreateRequest;
import com.quid.commerce.product.controller.dto.ProductGroupResponse;
import com.quid.commerce.product.usecase.productGroup.ProductGroupFindUseCase;
import com.quid.commerce.product.usecase.productGroup.ProductGroupSaveUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productGroup")
public class ProductGroupController {

    private final ProductGroupFindUseCase productGroupFindUseCase;
    private final ProductGroupSaveUseCase productGroupSaveUseCase;

    @GetMapping("/list")
    public List<ProductGroupResponse> getGroupList() {
        return productGroupFindUseCase.getGroupList();
    }

    @PostMapping
    public void createProductGroup(@RequestBody ProductGroupCreateRequest request) {
        productGroupSaveUseCase.createProductGroup(request);
    }

}
