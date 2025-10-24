package com.example.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, ItemDto> itemRedisTemplate(
            RedisConnectionFactory connectionFactory
    ) {
        RedisTemplate<String, ItemDto> template = new RedisTemplate<>();

        template.setConnectionFactory(connectionFactory);
        // Key를 어떤 직렬화기를 쓸지 설정해주는 것.
        // 여기서는 Redis 문자열 직렬화를 사용
        template.setKeySerializer(RedisSerializer.string());
        // Value는 json 직렬화
        template.setValueSerializer(RedisSerializer.json());

        return template;
    }
}
