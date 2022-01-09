package com.yangjia33.demo.controller;

import com.yangjia33.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjia33@outlook.com
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022-01-08 16:00
 */
@RestController
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String login(User user){
        if (!StringUtils.hasText(user.getUserName())){
            return "请输入用户名和密码！";
        }

        // 用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(), user.getPassword());

        try{
            // 进行验证
            subject.login(usernamePasswordToken);
        }catch (Exception e){
            log.error("登录异常:{}", e);
            return "登录异常";
        }

        return "login success";


    }
}
