package com.backend.uujob.service.impl;

import com.backend.uujob.entity.Recruit;
import com.backend.uujob.entity.RecruitTable;
import com.backend.uujob.mapper.RecruitMapper;
import com.backend.uujob.service.IRecruitService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecruitService extends ServiceImpl<RecruitMapper, Recruit> implements IRecruitService {
    @Override
    public void postRecruit(Recruit recruit) {//关系集不必DTO
        save(recruit);
    }

    @Override
    public boolean deleteRecruitById(Integer recruitId) {
        return removeById(recruitId);
    }

    @Override
    public List<Recruit> getPostRecruitByRecruiterId(Integer recruiterId) {
        QueryWrapper<Recruit> wrapper = new QueryWrapper<>();
        wrapper.eq("recruiter_id",recruiterId);
        List<Recruit> list = list(wrapper);
        return list;
    }

    public List<Recruit> getAllRecruit(){
        List<Recruit> list = list();
        return list;
    }
}
