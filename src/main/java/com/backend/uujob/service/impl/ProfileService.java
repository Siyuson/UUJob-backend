package com.backend.uujob.service.impl;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.backend.uujob.common.Constants;
import com.backend.uujob.common.RoleEnum;
import com.backend.uujob.controller.dto.ProfileDTO;
import com.backend.uujob.entity.Profile;
import com.backend.uujob.entity.Recruit;
import com.backend.uujob.entity.RecruitTable;
import com.backend.uujob.entity.Seek;
import com.backend.uujob.exception.ServiceException;
import com.backend.uujob.mapper.ProfileMapper;
import com.backend.uujob.mapper.SeekMapper;
import com.backend.uujob.service.IProfileService;
import com.backend.uujob.service.ISeekService;
import com.backend.uujob.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProfileService extends ServiceImpl<ProfileMapper, Profile> implements IProfileService {

    private final IUserService userService;
    private final ISeekService seekService;
    private final ProfileMapper profileMapper;
    @Autowired
    public ProfileService(IUserService userService, ISeekService seekService,ProfileMapper profileMapper) {
        this.userService = userService;
        this.seekService=seekService;
        this.profileMapper=profileMapper;
    }

    @Override
    public Profile postProfile(ProfileDTO profileDTO) {
        int loginIdAsInt=11;//StpUtil.getLoginIdAsInt();
        if (RoleEnum.ROLE_SEEKER.ordinal() == userService.getRoleById(loginIdAsInt)) { //检查用户是否有发布权限，后续可能用satoken的函数进行替代
            //保存profile
            Profile profile = new Profile();
            BeanUtil.copyProperties(profileDTO,profile,true);
            profile.setId(0);//自动递增而不指定
            profileMapper.insert(profile);
            Seek seek=new Seek(0,loginIdAsInt, profile.getId());
            seekService.postSeek(seek);
            return profile;
        } else {
            throw new ServiceException(Constants.CODE_401, "用户权限不足");
        }
    }

    @Override
    public List<Profile> getProfile() {
        int loginIdAsInt = 5;//StpUtil.getLoginIdAsInt();
        List<Seek> seekList = seekService.getPostSeekBySeekerId(loginIdAsInt);
        List<Profile> list=new ArrayList<>();
        for(Seek e:seekList)
        {
            list.add(getById(e.getSeeker_id()));
        }
        return list;
    }
    public List<Profile> getAllProfile(){
        return list();
    }
}
