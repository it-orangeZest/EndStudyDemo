package com.oz.redis_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private  RedisTemplate<String, Object> redisTemplate;
    @PostMapping("/set")
    public String set(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
        return "Key " + key + " set successfully";
    }

    @PostMapping("/setWithExpire")
    public String setWithExpire(@RequestParam String key,
                                @RequestParam String value,
                                @RequestParam long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
        return "Key " + key + " set with expire time " + timeout + " seconds";
    }

    @GetMapping("/get")
    public Object get(@RequestParam String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam String key) {
        return redisTemplate.delete(key);
    }
}
