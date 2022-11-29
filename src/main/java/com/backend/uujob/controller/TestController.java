package com.backend.uujob.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.backend.uujob.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    User user;
    @PostMapping("/login")
    public String login(String account,String password){
        //模拟登录校验
        if("2051971".equals(account) &&
                ("123").equals(password)){
            StpUtil.login(1);
            return "当前会话是否登录：" + StpUtil.isLogin() + StpUtil.getLoginId();
        }
        return "登陆失败";
    }

    @GetMapping("/islogin")
    public String test(){
        return "当前会话是否登录：" + StpUtil.isLogin();
    }
}


