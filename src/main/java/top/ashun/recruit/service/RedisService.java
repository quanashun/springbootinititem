package top.ashun.recruit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 18483
 */
@Service
public class RedisService {
    @Autowired
    public RedisTemplate redisTemplate;

    public <T> T getStringValue(Object key, Class<T> beanClass) throws JsonProcessingException {
        if (key == null) {
            return null;
        }
        Object o = redisTemplate.opsForValue().get(key);
        return o == null ? null : new ObjectMapper().readValue(o.toString(), beanClass);
    }
}