package com.backend.uujob.service;

import com.backend.uujob.controller.dto.ApplicationDTO;
import com.backend.uujob.controller.dto.ProfileDTO;
import com.backend.uujob.entity.Application;
import com.backend.uujob.mapper.ProfileMapper;
import com.backend.uujob.mapper.ApplicationMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService implements IApplicationService{
    @Resource
    ApplicationMapper applicationMapper;
    @Override
    public List<ApplicationDTO> getApplication(Integer recruittableid) {
        List<ApplicationDTO> applicationDTOS = new ArrayList<>();
        QueryWrapper<Application> wrapper = new QueryWrapper();
        wrapper.eq("recruittableid", recruittableid);
        List<Application> applications = applicationMapper.selectList(wrapper);
        for (Application application : applications) {
            ApplicationDTO applicationDTO = new ApplicationDTO();
            applicationDTO.setDate(application.getDate());
            applicationDTO.setRecruittableid(application.getRecruittableId());
            applicationDTO.setProfileid(application.getProfileId());
        }
        return applicationDTOS;
    }
    }
