package top.ashun.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ashun.recruit.pojo.vo.R;
import top.ashun.recruit.pojo.vo.UserPasswordLoginVO;
import top.ashun.recruit.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author 18483
 */
@RestController
@RequestMapping("/logins")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    //普通用户密码登录
    @PostMapping("/userPasswordLogin")
    public R ordinaryUserLoginByPassword(@RequestBody @Valid UserPasswordLoginVO userPasswordLoginVO, HttpServletRequest request){
        return R.success(userService.getUserTokenByPassword(userPasswordLoginVO.getUsername(), userPasswordLoginVO.getPassword()));
    }

    //普通用户验证码登录


    //管理员密码登录


    //管理员验证码登录

}
