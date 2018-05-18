package com.diablo.server;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.embedded.LinkedHashMapCacheBuilder;
import com.alicp.jetcache.redis.lettuce.RedisLettuceCacheBuilder;

import io.lettuce.core.RedisClient;

public class JetCacheTest {
    
    public static void redis() {
        RedisClient client = RedisClient.create("redis://192.168.91.87:7000");
        
        Cache<Long, String> cache = RedisLettuceCacheBuilder.createRedisLettuceCacheBuilder()
                .redisClient(client)
                .expireAfterWrite(200, TimeUnit.SECONDS)
                .buildCache();
    }
    
    public static void local() {
        Cache<String, Integer> cache = LinkedHashMapCacheBuilder.createLinkedHashMapCacheBuilder()
                .limit(100)
                .expireAfterWrite(200, TimeUnit.SECONDS)
                .buildCache();
        
        cache.put("20161111", 100, 1, TimeUnit.HOURS);
        
        Integer orderCount1 = cache.get("20161111");
        Integer orderCount2 = cache.computeIfAbsent("20161212", JetCacheTest::loadFromDatabase);
        
        System.out.println(orderCount1);
        System.out.println(orderCount2);
        cache.remove("20161212");
    }
    
    private static Integer loadFromDatabase(String key) {
        return 1000;
    }
    
    public static void main(String[] args) {
        int initialCapacity = (int)(100 * 1.4f);
        
        LinkedHashMap<String, String> map = new LinkedHashMap<>(initialCapacity, 0.75f,  true);
        local();
        
    }
}
