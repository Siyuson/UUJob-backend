package com.backend.uujob.service;

import com.backend.uujob.controller.dto.RecruitTableDTO;
import com.backend.uujob.entity.RecruitTable;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IRecruitTableService extends IService<RecruitTable> {
    RecruitTable postRecruitTable(RecruitTableDTO recruitTableDTO);
    List<RecruitTable> getPostRecruitTable();
    List<RecruitTable> getAllRecruitTable();

}
