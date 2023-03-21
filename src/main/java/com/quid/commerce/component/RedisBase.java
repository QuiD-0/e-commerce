package com.quid.commerce.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quid.commerce.product.domain.Product;
import java.time.Duration;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
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

    public <T> Set<T> getZsetData(String key, Class<T> classType) {
        Set set = redisTemplate.opsForZSet().rangeWithScores(key, 0, 9);
        return (Set) set.stream().map(object -> objectMapper.convertValue(object, classType))
                .collect(Collectors.toSet());
    }

    public void setZsetData(Object key, Object value, double score) {
        redisTemplate.opsForZSet().add(key, value, score);
    }
}