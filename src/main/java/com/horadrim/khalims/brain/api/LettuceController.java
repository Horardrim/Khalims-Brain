package com.horadrim.khalims.brain.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class LettuceController {

    @Autowired
    private StringRedisTemplate redis;

    @GetMapping("/set/{k}/{v}")
    public String set(@PathVariable String k, @PathVariable String v) {
        redis.opsForValue().set(k, v);
        return "ok";
    }

    @GetMapping("/get/{k}")
    public String get(@PathVariable String k) {
        return redis.opsForValue().get(k);
    }
}
