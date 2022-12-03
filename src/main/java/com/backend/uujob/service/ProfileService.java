package com.backend.uujob.service;

import com.backend.uujob.controller.dto.ProfileDTO;
import com.backend.uujob.entity.Profile;
import com.backend.uujob.mapper.ProfileMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService implements IProfileService{
@Resource
    ProfileMapper profileMapper;
@Override
public List<ProfileDTO> getProfile(Integer seekerid)
{
List<ProfileDTO> profileDTOS=new ArrayList<>();
return profileDTOS;
}
}
