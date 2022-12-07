package com.backend.uujob.service.impl;

import com.backend.uujob.entity.Application;
import com.backend.uujob.mapper.ApplicationMapper;
import com.backend.uujob.service.IApplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplicationService extends ServiceImpl<ApplicationMapper, Application> implements IApplicationService {
    @Override
    public void postApplication(Application application) {//关系集不必DTO
        save(application);
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
