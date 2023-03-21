package com.quid.commerce.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quid.commerce.product.domain.Product;
import java.time.Duration;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisBase {

    private final RedisTemplate redisTemplate;

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public <T> Optional<T> getData(String key, Class<T> classType) {
        Object result = redisTemplate.opsForValue().get(key);
        return result == null ? Optional.empty()
            : Optional.of(objectMapper.convertValue(result, classType));
    }

    public <T> void save(String key, T value, Duration expireTime) {
        redisTemplate.opsForValue().set(key, value, expireTime);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public <T> Set getZsetData(String key) {
        return redisTemplate.opsForZSet().rangeWithScores(key, 0, 9);
    }

    public void setZsetData(Product product) {
        redisTemplate.opsForZSet().add(product.getProductGroupId(), product.getProductId(), product.getPrice());
    }
}