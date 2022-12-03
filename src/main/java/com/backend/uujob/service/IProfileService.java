package com.backend.uujob.service;

import com.backend.uujob.controller.dto.ProfileDTO;
import com.backend.uujob.entity.Profile;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

public interface IProfileService{
    List<ProfileDTO> getProfile(Integer seekerid);
}
