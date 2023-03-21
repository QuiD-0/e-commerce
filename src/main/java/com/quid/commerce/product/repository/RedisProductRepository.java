package com.quid.commerce.product.repository;

import com.quid.commerce.component.RedisBase;
import com.quid.commerce.product.domain.Product;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisProductRepository {

    private final RedisBase redisBase;

    public Set getZsetValue(String key) {
        return redisBase.getZsetData(key);
    }

    public void setZsetValue(Product product) {
        redisBase.setZsetData(product.getProductGroupId(),product.getProductId(), product.getPrice());
    }
}
