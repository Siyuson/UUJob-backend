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
        return userService.saveOrUpdate(user);
    }
    //测试用的Get接口

    /**
     * 测试查询所有信息
     *
     * @return 返回所有用户信息
     */
    @GetMapping
    public List<User> findAll(){
        return userService.list();
    }
    /**
     * 删除数据
     *
     * @param id 要删除用户id
     * @return 返回删除结果
     */

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }
}
