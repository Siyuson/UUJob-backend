package com.backend.uujob.controller;

import com.backend.uujob.common.Result;
import com.backend.uujob.controller.dto.RecruitTableDTO;
import com.backend.uujob.entity.RecruitTable;
import com.backend.uujob.exception.ServiceException;
import com.backend.uujob.service.IRecruitTableService;
import com.backend.uujob.service.impl.RecruitTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruitTable")
public class RecruitTableController {
    private IRecruitTableService recruitTableService;
    @Autowired
    public RecruitTableController(RecruitTableService recruitTableService) {
        this.recruitTableService = recruitTableService;
    }

    @GetMapping("/all")
    public List<RecruitTable> test2(){
        return recruitTableService.getAllRecruitTable();
    }
    @GetMapping("/mypost")
    public List<RecruitTable> myPost(){
        return recruitTableService.getPostRecruitTable();
    }
    @PostMapping("")
    public Result postRT(@RequestBody RecruitTableDTO recruitTableDTO){//有效数据仅含title、position、salary、description
        try{
            recruitTableService.postRecruitTable(recruitTableDTO);
            return Result.success(recruitTableDTO);
        }catch(ServiceException e){
            return Result.error(e.getCode(), e.getMessage());
        }

    }
}
