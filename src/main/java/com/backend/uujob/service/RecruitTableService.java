package com.backend.uujob.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.backend.uujob.common.Constants;
import com.backend.uujob.common.RoleEnum;
import com.backend.uujob.controller.dto.RecruitTableDTO;
import com.backend.uujob.entity.RecruitTable;
import com.backend.uujob.exception.ServiceException;
import com.backend.uujob.mapper.RecruitTableMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
@Service
public class RecruitTableService extends ServiceImpl<RecruitTableMapper, RecruitTable> implements IRecruitTableService {
    private final UserService userService;
    @Autowired
    public RecruitTableService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public RecruitTable postRecruitTable(RecruitTableDTO recruitTableDTO) {
        int loginIdAsInt = 5;//StpUtil.getLoginIdAsInt();
        if (RoleEnum.ROLE_RECRUITER.ordinal() == userService.getRole(loginIdAsInt)) { //检查用户是否有发布权限，后续可能用satoken的函数进行替代
            RecruitTable recruitTable = new RecruitTable(loginIdAsInt);
            BeanUtil.copyProperties(recruitTableDTO, recruitTable, true);
            recruitTable.setId(0);//自动递增而不指定
            recruitTable.setDate(new Date());//当前时间
            recruitTable.setStatus((short)1);//默认已审核
            recruitTable.setPublisher_id(5);//当前用户id  loginIdAsInt
            save(recruitTable);
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
        int loginIdAsInt = StpUtil.getLoginIdAsInt();
        QueryWrapper<RecruitTable> wrapper = new QueryWrapper<>();
        wrapper.eq("publisher_id",loginIdAsInt);
        List<RecruitTable> list = list(wrapper);
        return list;
    }



    @Override
    public List<RecruitTable> getAllRecruitTable() {//修改 检查发布状态
        QueryWrapper<RecruitTable> wrapper = new QueryWrapper<>();
        wrapper.eq("status",1);
        List<RecruitTable> list = list(wrapper);
        return list;
    }
}