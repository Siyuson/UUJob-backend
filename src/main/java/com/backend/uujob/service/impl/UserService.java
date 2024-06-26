package com.backend.uujob.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.backend.uujob.common.Constants;
import com.backend.uujob.common.Result;
import com.backend.uujob.controller.dto.LoginDTO;
import com.backend.uujob.controller.dto.UserDTO;
import com.backend.uujob.controller.dto.UserPasswordDTO;
import com.backend.uujob.entity.User;
import com.backend.uujob.exception.ServiceException;
import com.backend.uujob.mapper.UserMapper;
import com.backend.uujob.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private UserMapper userMapper;
    //添加token后无法测试接口，完成其他功能点后再加入token
    @Override
    public Result login(LoginDTO loginDTO) {
        UserDTO userDTO = new UserDTO();
        User one = loginUserInfo(loginDTO);
        if (one != null) {
            StpUtil.login(one.getId());
            BeanUtil.copyProperties(one,userDTO,true);
            return Result.success(userDTO);
        } else {
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }
    }

    @Override
    public UserDTO register(UserDTO userDTO) {
        User one = registerInfo(userDTO);
        if (one == null) {
            one = new User();
            BeanUtil.copyProperties(userDTO,one,true);
            save(one); // 把copy完的用户对象存储到数据库
            return userDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户已存在");
        }
    }

    @Override
    public void updatePassword(UserPasswordDTO userPasswordDTO) {
        int update = userMapper.updatePassword(userPasswordDTO);
        if (update < 1) {
            throw new ServiceException(Constants.CODE_600, "密码错误");
        }
    }

    @Override
    public boolean saveData(User user){
        return saveOrUpdate(user);
    }

    @Override
    public boolean isLogin() {
        return StpUtil.isLogin();
    }

    @Override
    public void logout() {
        StpUtil.logout();
    }


    public short getRole(Integer id){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        User one = getOne(queryWrapper);
        return one.getRole();
    }

    private User loginUserInfo(LoginDTO loginDTO){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",loginDTO.getAccount());
        queryWrapper.eq("password", loginDTO.getPassword());
        return getOne(queryWrapper);
    }
    private User registerInfo(UserDTO userDTO){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",userDTO.getAccount());
        return getOne(queryWrapper);
    }

    @Override
    public short getRoleById(int id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        User one = getOne(queryWrapper);
        return one.getRole();
    }
}
