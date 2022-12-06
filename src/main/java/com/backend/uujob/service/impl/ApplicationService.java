package com.backend.uujob.service.impl;

import com.backend.uujob.controller.dto.ApplicationDTO;
import com.backend.uujob.entity.Application;
import com.backend.uujob.mapper.ApplicationMapper;
import com.backend.uujob.service.IApplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ApplicationService extends ServiceImpl<ApplicationMapper, Application> implements IApplicationService {
    @Override
    public Application postApplication(ApplicationDTO applicationDTO) {//提交简历申请
        //保存application
        Application application=new Application(applicationDTO.getProfile_id(),applicationDTO.getRecruittable_id(),applicationDTO.getDate());
        save(application);
        return application;
    }

    @Override
    public boolean deleteApplicationById(int profileId) {
       return removeById(profileId);
    }

    public List<Application> getAllRecruitTable(){
        List<Application> list = list();
        return list;
    }
}
