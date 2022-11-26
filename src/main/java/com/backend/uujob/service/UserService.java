package com.backend.uujob.service;

import com.backend.uujob.entity.User;
import com.backend.uujob.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    //引入user相关功能
    public boolean saveService(User user){
        return super.saveOrUpdate(user);
    }
}
