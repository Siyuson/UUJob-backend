package com.backend.uujob.service;

import com.backend.uujob.controller.dto.RecruitTableDTO;
import com.backend.uujob.entity.RecruitTable;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IRecruitTableService extends IService<RecruitTable> {
    RecruitTable postRecruitTable(RecruitTableDTO recruitTableDTO);


}
