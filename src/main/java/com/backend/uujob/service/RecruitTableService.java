package com.backend.uujob.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.backend.uujob.common.Constants;
import com.backend.uujob.controller.dto.RecruitTableDTO;
import com.backend.uujob.entity.RecruitTable;
import com.backend.uujob.exception.ServiceException;
import com.backend.uujob.mapper.RecruitTableMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.config.builder.Service;

import java.security.Provider;
import java.util.List;

public class RecruitTableService extends ServiceImpl<RecruitTableMapper, RecruitTable> implements IRecruitTableService {
    private UserService userService;
    @Override
    public RecruitTable postRecruitTable(RecruitTableDTO recruitTableDTO) {
        int loginIdAsInt = StpUtil.getLoginIdAsInt();
        if (userService.getCharacter(loginIdAsInt) == 1) { //检查用户是否有发布权限，后续可能用satoken的函数进行替代
            RecruitTable recruitTable = new RecruitTable(loginIdAsInt);
            BeanUtil.copyProperties(recruitTable, recruitTable, true);
            save(recruitTable);
            return recruitTable;
        } else {
            throw new ServiceException(Constants.CODE_401, "用户权限不足");
        }
    }

    @Override
    public List<RecruitTable> getPostRecruitTable() {
        int loginIdAsInt = StpUtil.getLoginIdAsInt();
        QueryWrapper<RecruitTable> wrapper = new QueryWrapper<>();
        wrapper.eq("publisherid",loginIdAsInt);
        List<RecruitTable> list = list(wrapper);
        return list;
    }
}