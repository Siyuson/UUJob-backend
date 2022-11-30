package com.backend.uujob.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.backend.uujob.common.Constants;
import com.backend.uujob.controller.dto.RecruitTableDTO;
import com.backend.uujob.entity.RecruitTable;
import com.backend.uujob.exception.ServiceException;
import com.backend.uujob.mapper.RecruitTableMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class RecruitTableService extends ServiceImpl<RecruitTableMapper, RecruitTable> implements IRecruitTableService {
    private UserService userService;
    @Override
    public RecruitTable postRecruitTable(RecruitTableDTO recruitTableDTO) {
        int loginIdAsInt = StpUtil.getLoginIdAsInt();
        if (userService.getCharacter(loginIdAsInt) == 1) {
            RecruitTable recruitTable = new RecruitTable(loginIdAsInt);
            BeanUtil.copyProperties(recruitTable, recruitTable, true);
            save(recruitTable);
            return recruitTable;
        } else {
            throw new ServiceException(Constants.CODE_401, "用户权限不足");
        }
    }
}