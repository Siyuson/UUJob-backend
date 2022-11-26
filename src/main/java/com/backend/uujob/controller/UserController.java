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

    /**
     * 数据插入或数据更新，@RequestBody将前台的json对象转化为java对象
     *
     * @param user 用户实体类
     * @reurn 返回插入或更新结果
     */
    @PostMapping
    private boolean save(@RequestBody User user){
        return userService.saveService(user);
    }
    //测试用的Get接口
    @GetMapping
    public List<User> index(){
        List<User> all = userMapper.findAll();
        return all;
    }
}
