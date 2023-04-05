package com.quid.commerce.product.repository.redis;

import com.quid.commerce.component.RedisBase;
import com.quid.commerce.product.domain.Product;
import java.time.Duration;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisProductRepository {

    private final static Duration CACHE_TTL = Duration.ofSeconds(10);
    private final RedisBase redisBase;

    public void save(String key, Product value) {
        redisBase.save(getKey(key), value, CACHE_TTL);
    }

    public Optional<Product> find(String key) {
        return redisBase.getData(getKey(key), Product.class);
    }

    public Set getZsetValue(String key) {
        return redisBase.getZsetData(key);
    }

    public void setZsetValue(Product product) {
        redisBase.setZsetData(product.getGroupCode(),product.getId(), product.getPrice());
    }

    public void deleteZsetValue(Product product) {
        redisBase.deleteZsetData(product.getGroupCode(), product.getId());
    }

    private static String getKey(String key) {
        return "product::" + key;
    }
}
