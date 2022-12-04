package com.backend.uujob.controller;

import com.backend.uujob.common.Result;
import com.backend.uujob.controller.dto.ApplicationDTO;
import com.backend.uujob.controller.dto.ProfileDTO;
import com.backend.uujob.controller.dto.RecruitTableDTO;
import com.backend.uujob.entity.Application;
import com.backend.uujob.entity.Profile;
import com.backend.uujob.entity.RecruitTable;
import com.backend.uujob.exception.ServiceException;
import com.backend.uujob.service.ApplicationService;
import com.backend.uujob.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private ProfileService profileService;
    private ApplicationService applicationService;
    @Autowired
    public ProfileController(ProfileService profileService,ApplicationService applicationService) {
        this.profileService = profileService;
        this.applicationService=applicationService;
    }

    @GetMapping("/all")
    public List<Profile> test3(){
        return profileService.getAllProfile();
    }

    @Transactional
    @PostMapping("/{recruittable_id}")
    public Result postProfile(@PathVariable Integer recruittable_id,@RequestBody ProfileDTO profileDTO){//id和seeker_id会被忽略
        try{
            Profile profile = profileService.postProfile(profileDTO);
            ApplicationDTO a=new ApplicationDTO(profile.getId(),recruittable_id,new Date());
            Application application=applicationService.postApplication(a);
            return Result.success(profile);
        }catch(ServiceException e){
            return Result.error(e.getCode(), e.getMessage());
        }
    }
}
