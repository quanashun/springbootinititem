package top.ashun.recruit.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import top.ashun.recruit.entity.User;
import top.ashun.recruit.entity.UserInfo;
import top.ashun.recruit.mapper.UserMapper;
import top.ashun.recruit.pojo.vo.UserLoginRespVO;

import java.util.List;

/**
 * @author 18483
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AdministratorServiceImpl administratorService;

    public UserLoginRespVO getUserTokenByPassword(String userId, String rawPassword) {
        User user = baseMapper.selectById(userId);
        if (user != null) {
            //密码匹配成功
            if (user.getPassword().equals(bCryptPasswordEncoder.encode(rawPassword))) {
                UserInfo userInfo = new UserInfo();
                BeanUtils.copyProperties(user, userInfo);
                List<String> roles = baseMapper.getRolesById(userId);
                return administratorService.generateResponseVO(userInfo, roles);
            }
        }
        return null;
    }
}
