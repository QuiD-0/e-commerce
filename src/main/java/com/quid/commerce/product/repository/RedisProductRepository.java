package com.quid.commerce.product.repository;

import com.quid.commerce.component.RedisBase;
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

}
