package com.quid.commerce.product.controller;

import com.quid.commerce.product.controller.request.ProductCreateRequest;
import com.quid.commerce.product.controller.response.ProductSearchResponse;
import com.quid.commerce.product.controller.request.UpdateProductPriceRequest;
import com.quid.commerce.product.usecase.product.ProductDeleteUseCase;
import com.quid.commerce.product.usecase.product.ProductFindUseCase;
import com.quid.commerce.product.usecase.product.ProductSaveUseCase;
import com.quid.commerce.product.usecase.product.ProductUpdateUseCase;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductFindUseCase productFindUseCase;
    private final ProductSaveUseCase productSaveUseCase;
    private final ProductUpdateUseCase productUpdateUseCase;
    private final ProductDeleteUseCase productDeleteUseCase;

    @GetMapping("/sort/{code}")
    public Set getSortedProductList(@PathVariable(name = "code") String code) {
        return productFindUseCase.getSortedProductList(code);
    }

    @PostMapping
    public void createProduct(@RequestBody ProductCreateRequest request) {
        productSaveUseCase.createProduct(request);
    }

    @PutMapping
    public void updateProductPrice(@RequestBody UpdateProductPriceRequest request) {
        productUpdateUseCase.updateProduct(request);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        productDeleteUseCase.deleteProduct(id);
    }

    @GetMapping("/search/{keyword}")
    public List<ProductSearchResponse> searchProduct(@PathVariable(name = "keyword") String keyword) {
        return productFindUseCase.searchProduct(keyword);
    }

}
