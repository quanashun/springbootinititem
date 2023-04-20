package top.ashun.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 18483
 */
@RestController
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    public String testController(String s){
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        valueOps.set("myKey", s);
        return  valueOps.get("myKey");
    }
}
