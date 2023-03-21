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

    public <T> Set<T> getZsetValue(String key, Class<T> classType) {
        return redisBase.getZsetData(key, classType);
    }

    public void setZsetValue(Product product) {
        redisBase.setZsetData(product.getProductGroupId(),product.getProductId(), product.getPrice());
    }
}
