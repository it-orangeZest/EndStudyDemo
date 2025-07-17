package com.oz.redis_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemoApplicationTests {

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	@Test
	void contextLoads() {
	}

	@Test
	void testRedisOperations(){
		String key = "testKey";
		String value ="testValue";
		// 测试设置值
		redisTemplate.opsForValue().set(key, value);

		//测试获取值
		Object retrievedValue =redisTemplate.opsForValue().get(key);

	}

}
