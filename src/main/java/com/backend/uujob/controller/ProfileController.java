package com.backend.uujob.controller;

import com.backend.uujob.controller.dto.ProfileDTO;
import com.backend.uujob.entity.Profile;
import com.backend.uujob.service.IProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProfileController {
    @Resource
    IProfileService IProfileService;
    @GetMapping("getProfile")
    public ResponseEntity<List<ProfileDTO>> getProfile(
            @RequestParam(value="seekerid")Integer seekerid
    ){
        try {
            return ResponseEntity.ok(IProfileService.getProfile(seekerid));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
}
