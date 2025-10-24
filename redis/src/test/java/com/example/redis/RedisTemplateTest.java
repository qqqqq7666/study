package com.example.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTemplateTest {
    @Autowired
    // Redis의 문자열 타입 String을 의미하지 않음.
    // Redis와 소통을 할 때 Java의 String으로 응답하겠다는 의미임.
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, ItemDto> itemRedisTemplate;

    @Test
    public void stringOpsTest() {
        // 문자열 조작을 위한 클래스
        ValueOperations<String, String> ops
                // RedisTemplate에 설정된 타입을 바탕으로
                // Redis 문자열을 조작할 것을 의미
                = stringRedisTemplate.opsForValue();

        // SET simpKey simpleValue
        ops.set("simpleKey", "simpleValue");
        System.out.println(ops.get("simpleKey"));

        // 이처럼 Redis String만 쓰겠다는 것이 아니라
        SetOperations<String, String> setOps = stringRedisTemplate.opsForSet();
        // SADD hobbies games
        setOps.add("hobbies", "games");
        setOps.add("hobbies", "coding", "drink", "games");
        System.out.println(setOps.size("hobbies"));

        stringRedisTemplate.expire("hobbies", 10, TimeUnit.SECONDS);
        stringRedisTemplate.delete("simpleKey");
    }

    @Test
    public void itemRedisTest() {
        ValueOperations<String, ItemDto> ops = itemRedisTemplate.opsForValue();
        ops.set("my:keyboard", ItemDto.builder()
                .name("mechanical keyboard")
                .price(300)
                .description("what?")
                .build());

        System.out.println(ops.get("my:keyboard"));

        ops.set("my:mouse", ItemDto.builder()
                .name("mouse")
                .price(10000000)
                .description("whaaaat?")
                .build());

        System.out.println(ops.get("my:mouse"));
    }
}
