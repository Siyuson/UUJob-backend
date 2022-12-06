package com.backend.uujob.service;

import com.backend.uujob.controller.dto.ApplicationDTO;
import com.backend.uujob.entity.Application;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;


public interface IApplicationService extends IService<Application> {
    Application postApplication(ApplicationDTO applicationDTO);
    boolean deleteApplicationById(int profileId);
}