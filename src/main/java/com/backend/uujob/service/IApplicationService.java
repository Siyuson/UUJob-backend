package com.backend.uujob.service;

import com.backend.uujob.entity.Application;
import com.baomidou.mybatisplus.extension.service.IService;


public interface IApplicationService extends IService<Application> {
    void postApplication(Application application);
    boolean deleteApplicationById(int profileId);
}