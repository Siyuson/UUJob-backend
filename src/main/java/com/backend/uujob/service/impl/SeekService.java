package com.backend.uujob.service.impl;

import com.backend.uujob.entity.Recruit;
import com.backend.uujob.entity.Seek;
import com.backend.uujob.mapper.SeekMapper;
import com.backend.uujob.service.ISeekService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeekService extends ServiceImpl<SeekMapper, Seek> implements ISeekService {
    @Override
    public void postSeek(Seek seek) {//关系集不必DTO
        save(seek);
    }

    @Override
    public boolean deleteSeekById(Integer seekId) {
        return removeById(seekId);
    }

    @Override
    public List<Seek> getPostSeekBySeekerId(Integer seekId) {
        QueryWrapper<Seek> wrapper = new QueryWrapper<>();
        wrapper.eq("seek_id",seekId);
        List<Seek> list = list(wrapper);
        return list;
    }

    public List<Seek> getAllSeek(){
        List<Seek> list = list();
        return list;
    }
}
