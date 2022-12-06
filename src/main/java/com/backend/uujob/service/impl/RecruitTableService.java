package com.backend.uujob.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.backend.uujob.common.Constants;
import com.backend.uujob.common.RoleEnum;
import com.backend.uujob.controller.dto.RecruitTableDTO;
import com.backend.uujob.entity.Recruit;
import com.backend.uujob.entity.RecruitTable;
import com.backend.uujob.exception.ServiceException;
import com.backend.uujob.mapper.RecruitTableMapper;
import com.backend.uujob.service.IRecruitService;
import com.backend.uujob.service.IRecruitTableService;
import com.backend.uujob.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RecruitTableService extends ServiceImpl<RecruitTableMapper, RecruitTable> implements IRecruitTableService {
    private final UserService userService;//为了getRole，不用接口回调
    private final IRecruitService recruitService;
    @Autowired
    public RecruitTableService(UserService userService,IRecruitService recruitService) {
        this.userService = userService;
        this.recruitService=recruitService;
    }

    @Override
    public RecruitTable postRecruitTable(RecruitTableDTO recruitTableDTO) {
        int loginIdAsInt = 4;//StpUtil.getLoginIdAsInt();
        if (RoleEnum.ROLE_RECRUITER.ordinal() == userService.getRole(loginIdAsInt)) { //检查用户是否有发布权限，后续可能用satoken的函数进行替代
            RecruitTable recruitTable = new RecruitTable();
            BeanUtil.copyProperties(recruitTableDTO, recruitTable, true);
            recruitTable.setStatus((short)1);//默认已审核
            save(recruitTable);
            Recruit recruit=new Recruit(0,loginIdAsInt,recruitTable.getId());
            recruitService.postRecruit(recruit);
            return recruitTable;
        } else {
            throw new ServiceException(Constants.CODE_401, "用户权限不足");
        }
    }

    /**
     * 查询登录用户所发布过的招聘信息
     * @return
     */
    @Override
    public List<RecruitTable> getPostRecruitTable() {
        int loginIdAsInt = 4;//StpUtil.getLoginIdAsInt();
        List<Recruit> recruitList = recruitService.getPostRecruitByRecruiterId(loginIdAsInt);
        List<RecruitTable> list=new ArrayList<>();
        for(Recruit e:recruitList)
        {
            list.add(getById(e.getRecruiter_id()));
        }
        return list;
    }



    @Override
    public List<RecruitTable> getAllRecruitTable() {//修改 检查发布状态
        QueryWrapper<RecruitTable> wrapper = new QueryWrapper<>();
        wrapper.eq("status",1);
        return list(wrapper);
    }
}