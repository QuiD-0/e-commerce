package com.quid.commerce.product.repository.redis;

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
        redisBase.setZsetData(product.getGroupCode(),product.getProductId(), product.getPrice());
    }

    public void deleteZsetValue(Product product) {
        redisBase.deleteZsetData(product.getGroupCode(), product.getProductId());
    }
}
