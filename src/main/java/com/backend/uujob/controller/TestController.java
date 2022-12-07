package com.backend.uujob.controller;


import com.backend.uujob.common.Result;
import com.backend.uujob.controller.dto.LoginDTO;
import com.backend.uujob.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserService userService;

//    @GetMapping
//    public User get(){
//        LoginDTO loginDTO = new LoginDTO("2051971","123");
//        return userService.loginUserInfo(loginDTO);
//    }
    @PostMapping("/login")
    public Result login(@RequestBody LoginDTO loginDTO){
        //LoginDTO loginDTO = new LoginDTO("2051971","123");
        //模拟登录校验
        return userService.login(loginDTO);
        //System.out.println(userService.isLogin());
    }

    @GetMapping("/islogin")
    public String test(){
        return "当前会话是否登录：" + userService.isLogin();
    }

}


