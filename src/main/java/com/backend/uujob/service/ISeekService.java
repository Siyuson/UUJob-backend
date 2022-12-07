package com.backend.uujob.service;

import com.backend.uujob.entity.Application;
import com.backend.uujob.entity.Seek;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ISeekService extends IService<Seek> {
    void postSeek(Seek seek);
    boolean deleteSeekById(Integer seekId);
    public List<Seek> getPostSeekBySeekerId(Integer seekId);
}
