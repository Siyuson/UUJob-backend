package com.backend.uujob.mapper;

import com.backend.uujob.entity.RecruitTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface RecruitTableMapper extends BaseMapper<RecruitTable> {
    List<RecruitTable> getById();
}
