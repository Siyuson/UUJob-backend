package com.backend.uujob.service;

import com.backend.uujob.controller.dto.ProfileDTO;
import com.backend.uujob.entity.Profile;
import com.backend.uujob.entity.RecruitTable;
import com.backend.uujob.mapper.ProfileMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    QueryWrapper<Profile> wrapper = new QueryWrapper();
    wrapper.eq("seekerid",seekerid);
    List<Profile> profiles=profileMapper.selectList(wrapper);
    for(Profile profile:profiles)
    {
        ProfileDTO profileDTO=new ProfileDTO();
        profileDTO.setAge(profile.getAge());
        profileDTO.setId(profile.getId());
        profileDTO.setEdu(profile.getEdu());
        profileDTO.setEmail(profile.getEmail());
        profileDTO.setDescription(profile.getDescription());
        profileDTO.setSex(profile.getSex());
        profileDTO.setSeekerid(profile.getSeekerId());
        profileDTOS.add(profileDTO);
    }
return profileDTOS;
}
}
