package com.backend.uujob.controller;

import com.backend.uujob.common.Result;
import com.backend.uujob.controller.dto.ProfileDTO;
import com.backend.uujob.entity.Application;
import com.backend.uujob.entity.Profile;
import com.backend.uujob.exception.ServiceException;
import com.backend.uujob.service.IProfileService;
import com.backend.uujob.service.impl.ApplicationService;
import com.backend.uujob.service.impl.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final IProfileService profileService;
    private final ApplicationService applicationService;
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
    @PostMapping("/{recruitTable_id}")
    public Result postProfile(@PathVariable Integer recruitTable_id, @RequestBody ProfileDTO profileDTO){
        try{
            Profile profile = profileService.postProfile(profileDTO);
            Application a = new Application(profile.getId(), recruitTable_id,new Date());
            applicationService.postApplication(a);
            return Result.success(profile);
        }catch(ServiceException e){
            return Result.error(e.getCode(), e.getMessage());
        }
    }

    public boolean deleteProfile(Integer profileId){
        return applicationService.deleteApplicationById(profileId);
    }

}
