package com.backend.uujob.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.backend.uujob.common.Constants;
import com.backend.uujob.common.RoleEnum;
import com.backend.uujob.controller.dto.RecruitTableDTO;
import com.backend.uujob.entity.Recruit;
import com.backend.uujob.entity.RecruitTable;
import com.backend.uujob.exception.ServiceException;
import com.backend.uujob.mapper.RecruitTableMapper;
import com.backend.uujob.mapper.UserMapper;
import com.backend.uujob.service.IRecruitService;
import com.backend.uujob.service.IRecruitTableService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class RecruitTableService extends ServiceImpl<RecruitTableMapper, RecruitTable> implements IRecruitTableService {
    private final UserService userService;//为了getRole，不用接口回调
    @Resource
    private final RecruitTableMapper recruitTableMapper;//为了getRole，不用接口回调
    private final IRecruitService recruitService;
    @Autowired
    public RecruitTableService(UserService userService, RecruitTableMapper recruitTableMapper, IRecruitService recruitService) {
        this.userService = userService;
        this.recruitTableMapper = recruitTableMapper;
        this.recruitService=recruitService;
    }

    @Override
    public RecruitTable postRecruitTable(RecruitTableDTO recruitTableDTO) {
        int loginIdAsInt = 4;//StpUtil.getLoginIdAsInt();
        if (RoleEnum.ROLE_RECRUITER.ordinal() == userService.getRole(loginIdAsInt)) { //检查用户是否有发布权限，后续可能用satoken的函数进行替代
            RecruitTable recruitTable = new RecruitTable();
            BeanUtil.copyProperties(recruitTableDTO, recruitTable, true);
            recruitTable.setStatus((short)1);//默认已审核
            recruitTable.setDate(new Date());//不能写到构造函数里，会被copyProperties覆盖
            recruitTable.setId(0);
            recruitTableMapper.insert(recruitTable);//为了拿到自增后的id，不能用save
            //System.out.println(recruitTable);
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