package com.diablo.server.config.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.diablo.common.config.service.PayConfigService;
import com.diablo.server.BaseTest;

public class PayConfigServiceImplTest extends BaseTest {
    
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    @Autowired
    private PayConfigService payConfigService;
    
    @Test
    public void query() {
        String value = redisTemplate.opsForValue().get("quant:stock:screen:dictionary");
        System.out.println(value);
        
        String query = payConfigService.query();
        System.out.println(query);
    }
}