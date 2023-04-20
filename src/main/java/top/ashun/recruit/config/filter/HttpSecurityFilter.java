package top.ashun.recruit.config.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import top.ashun.recruit.pojo.dto.UserTokenDTO;
import top.ashun.recruit.service.RedisService;
import top.ashun.recruit.service.UserServiceImpl;
import top.ashun.recruit.util.RequestUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 18483
 */ //在请求处理前验证token
@Component
@Slf4j
public class HttpSecurityFilter extends OncePerRequestFilter {
    @Autowired
    private RedisService redisService;

    @Autowired
    private UserServiceImpl userService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 在这里获取token的用户和权限
        String token = httpServletRequest.getHeader("Authorization");
        if (token != null) {
            UserTokenDTO userTokenDTO = redisService.getStringValue(token, UserTokenDTO.class);
            if (userTokenDTO != null) {
                log.info(
                        "user id : {} , uri : {} , method : {} , params : {}",
                        userTokenDTO.getUserInfo().getId(),
                        httpServletRequest.getRequestURI(),
                        httpServletRequest.getMethod(),
                        new ObjectMapper().writeValueAsString(httpServletRequest.getParameterMap())
                );
                RequestUtil.setUserTokenDTO(userTokenDTO);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}
