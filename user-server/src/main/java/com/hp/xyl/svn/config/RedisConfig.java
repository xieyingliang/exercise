package com.hp.xyl.svn.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * redis配置
 *
 * @author xyl
 * @date 2019/9/1 16:10
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    /**
     * 选择Redis作为默认缓存工具
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jacksonSerial = new Jackson2JsonRedisSerializer(Object.class);
        return template;
    }
}
