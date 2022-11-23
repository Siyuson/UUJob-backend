package com.backend.uujob.service;

import com.backend.uujob.entity.User;
import com.backend.uujob.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //引入user相关功能
    @Autowired
    private UserMapper userMapper;

    public int save(User user){
        if(user.getId() == null){
            return userMapper.insert(user);

        }else{
            return userMapper.update(user);
        }
    }
}
