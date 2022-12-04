package com.backend.uujob.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.backend.uujob.common.Constants;
import com.backend.uujob.common.RoleEnum;
import com.backend.uujob.controller.dto.ApplicationDTO;
import com.backend.uujob.entity.Application;
import com.backend.uujob.exception.ServiceException;
import com.backend.uujob.mapper.ApplicationMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Service
public class ApplicationService extends ServiceImpl<ApplicationMapper, Application> implements IApplicationService {
    private UserService userService;
    @Autowired
    public ApplicationService(UserService userService) {
        this.userService = userService;
    }
    @Override
    public Application postApplication(ApplicationDTO applicationDTO) {
        //保存application
        Application application=new Application(applicationDTO.getProfile_id(),applicationDTO.getRecruittable_id(),applicationDTO.getDate());
        save(application);
        return application;
    }


    public List<Application> getAllRecruitTable(){
        List<Application> list = list();
        return list;
    }
}
