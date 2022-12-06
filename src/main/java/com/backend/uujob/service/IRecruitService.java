package com.backend.uujob.service;

import com.backend.uujob.entity.Application;
import com.backend.uujob.entity.Recruit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IRecruitService extends IService<Recruit> {
    void postRecruit(Recruit recruit);
    boolean deleteRecruitById(Integer recruitId);
    public List<Recruit> getPostRecruitByRecruiterId(Integer recruiterId);
}
