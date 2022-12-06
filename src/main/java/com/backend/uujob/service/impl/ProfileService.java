package com.backend.uujob.service.impl;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.backend.uujob.common.Constants;
import com.backend.uujob.common.RoleEnum;
import com.backend.uujob.controller.dto.ProfileDTO;
import com.backend.uujob.entity.Profile;
import com.backend.uujob.exception.ServiceException;
import com.backend.uujob.mapper.ProfileMapper;
import com.backend.uujob.service.IProfileService;
import com.backend.uujob.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProfileService extends ServiceImpl<ProfileMapper, Profile> implements IProfileService {

    private final IUserService userService;
    @Autowired
    public ProfileService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Profile postProfile(ProfileDTO profileDTO) {
        StpUtil.login(11); //StpUtil.getLoginIdAsInt();
        if (RoleEnum.ROLE_SEEKER.ordinal() == userService.getRoleById(StpUtil.getLoginIdAsInt())) { //检查用户是否有发布权限，后续可能用satoken的函数进行替代
            //保存profile
            Profile profile = new Profile();
            BeanUtil.copyProperties(profileDTO,profile,true);
            profile.setId(0);//自动递增而不指定
            profile.setSeeker_id(11);//当前用户id  loginIdAsInt
            save(profile);
            return profile;
        } else {
            throw new ServiceException(Constants.CODE_401, "用户权限不足");
        }
    }

    @Override
    public List<Profile> getProfile() {
        int loginIdAsInt = StpUtil.getLoginIdAsInt();
        QueryWrapper<Profile> wrapper = new QueryWrapper<>();
        wrapper.eq("publisherid",loginIdAsInt);
        return list(wrapper);
    }
    public List<Profile> getAllProfile(){
        return list();
    }
}
