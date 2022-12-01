package com.backend.uujob.controller;


import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.log.Log;
import com.backend.uujob.common.RoleEnum;
import com.backend.uujob.controller.dto.LoginDTO;
import com.backend.uujob.controller.dto.UserDTO;
import com.backend.uujob.entity.User;
import com.backend.uujob.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserService userService = new UserService();
//    @GetMapping
//    public User get(){
//        LoginDTO loginDTO = new LoginDTO("2051971","123");
//        return userService.loginUserInfo(loginDTO);
//    }

    public UserDTO login(LoginDTO loginDTO){
        //LoginDTO loginDTO = new LoginDTO("2051971","123");
        //模拟登录校验

        return userService.login(loginDTO);
        //System.out.println(userService.isLogin());
    }
//    @PostMapping
//    public UserDTO back(@RequestBody LoginDTO loginDTO){
//        return userService.login(loginDTO);
//    }
    @PostMapping
    public User register(@RequestBody UserDTO userDTO){
        return userService.register(userDTO);
    }

    @GetMapping("/islogin")
    public String test(){
        return "当前会话是否登录：" + StpUtil.isLogin();
    }
}


