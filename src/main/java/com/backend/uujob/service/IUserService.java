package com.backend.uujob.service;

import com.backend.uujob.controller.dto.LoginDTO;
import com.backend.uujob.controller.dto.UserDTO;
import com.backend.uujob.controller.dto.UserPasswordDTO;
import com.backend.uujob.entity.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserService extends IService<User> {
    UserDTO login(LoginDTO loginDTO);

    User register(UserDTO userDTO);

    void updatePassword(UserPasswordDTO userPasswordDTO);

    boolean saveData(User user);

    boolean isLogin();
}
