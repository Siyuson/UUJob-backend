package com.backend.uujob.service;


import com.backend.uujob.controller.dto.ApplicationDTO;
import java.util.List;
import com.backend.uujob.entity.Application;
import com.baomidou.mybatisplus.extension.service.IService;
public interface IApplicationService extends IService<Application> {
    List<ApplicationDTO> getApplication(Integer recruittableid);
    void postApplication(Application application);
    boolean deleteApplicationById(int profileId);
}
