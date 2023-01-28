package com.hendisantika.springbootjedis.service;

import com.hendisantika.springbootjedis.model.Pincode;
import com.hendisantika.springbootjedis.repository.PincodeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jedis
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/28/23
 * Time: 20:45
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class PincodeService implements PincodeRepository {

    private static final String CACHE_NAME = "Pincode";

    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations<String, Long, Pincode> hashOperations;

    @PostConstruct
    private void initializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Pincode pincode) {
        hashOperations.put(CACHE_NAME, pincode.id(), pincode);
    }

    @Override
    public Pincode find(Long id) {
        return hashOperations.get(CACHE_NAME, id);
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete(CACHE_NAME, id);
    }
}
