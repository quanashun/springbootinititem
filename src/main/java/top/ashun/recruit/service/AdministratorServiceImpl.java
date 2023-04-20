package top.ashun.recruit.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import top.ashun.recruit.config.filter.UserInfo;
import top.ashun.recruit.entity.Administrator;
import top.ashun.recruit.entity.User;
import top.ashun.recruit.mapper.AdministratorMapper;
import top.ashun.recruit.pojo.dto.UserTokenDTO;
import top.ashun.recruit.pojo.vo.UserLoginRespVO;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 18483
 */
@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, Administrator> {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RedisTemplate redisTemplate;

    public UserLoginRespVO getUserTokenByPassword(String userId, String rawPassword) {
        Administrator user = baseMapper.selectById(userId);
        if(user != null){
            //密码匹配成功
            if(user.getPassword().equals(bCryptPasswordEncoder.encode(rawPassword))) {
                UserInfo userInfo = new UserInfo();
                BeanUtils.copyProperties(user,userInfo);
                List<String> roles = baseMapper.getRolesById(userId);
                return generateResponseVO(userInfo,roles);
            }
        }
        return null;
    }

    public UserLoginRespVO generateResponseVO(UserInfo userInfo,List<String> roles){
        UserTokenDTO userTokenDTO = new UserTokenDTO();
        UserLoginRespVO resp = new UserLoginRespVO();

        resp.setUserInfo(userInfo);
        userTokenDTO.setUserInfo(userInfo);

        resp.setRoleList(roles);
        userTokenDTO.setRoleList(roles);

        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(token, userTokenDTO, 120, TimeUnit.HOURS);
        resp.setToken(token);
        return resp;
    }
}
