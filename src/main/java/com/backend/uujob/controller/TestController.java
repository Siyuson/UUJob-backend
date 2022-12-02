package com.backend.uujob.controller;


import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.backend.uujob.common.RoleEnum;
import com.backend.uujob.controller.dto.LoginDTO;
import com.backend.uujob.controller.dto.RecruitTableDTO;
import com.backend.uujob.controller.dto.UserDTO;
import com.backend.uujob.entity.RecruitTable;
import com.backend.uujob.entity.User;
import com.backend.uujob.service.RecruitTableService;
import com.backend.uujob.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserService userService = new UserService();
    @Autowired
    private RecruitTableService recruitTableService;
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

    @GetMapping
    public List<RecruitTable> test2(){
        return recruitTableService.getAllRecruitTable();
    }
    @GetMapping("/islogin")
    public String test(){
        return "当前会话是否登录：" + StpUtil.isLogin();
    }
}


