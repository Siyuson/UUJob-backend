package com.backend.uujob.controller;

import com.backend.uujob.entity.User;
import com.backend.uujob.mapper.UserMapper;
import com.backend.uujob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    //引入接口
    @Resource
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @PostMapping
    private Integer save(@RequestBody User user){
        return userService.save(user);
    }
    //测试用的Get接口
    @GetMapping
    public List<User> index(){
        List<User> all = userMapper.findAll();
        return all;
    }
}
