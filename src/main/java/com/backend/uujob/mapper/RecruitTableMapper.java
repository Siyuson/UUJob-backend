package com.backend.uujob.mapper;

import com.backend.uujob.entity.RecruitTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RecruitTableMapper extends BaseMapper<RecruitTable> {
    List<RecruitTable> getById();
}
