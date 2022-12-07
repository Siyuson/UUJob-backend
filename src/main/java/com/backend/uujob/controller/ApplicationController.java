package com.backend.uujob.controller;

import com.backend.uujob.controller.dto.ApplicationDTO;
import com.backend.uujob.controller.dto.ProfileDTO;
import com.backend.uujob.service.IApplicationService;
import com.backend.uujob.service.IProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ApplicationController {
    @Resource
    IApplicationService IApplicationService;
    @GetMapping("getApplication")
    public ResponseEntity<List<ApplicationDTO>> getProfile(
            @RequestParam(value="recruittableid")Integer recruittableid
    ){
        try {
            return ResponseEntity.ok(IApplicationService.getApplication(recruittableid));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
}
