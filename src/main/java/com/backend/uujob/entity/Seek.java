package com.backend.uujob.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "seek")
public class Seek {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer seeker_id;
    private Integer profile_id;

    public Seek(Integer id, Integer seeker_id, Integer profile_id) {
        this.id = id;
        this.seeker_id = seeker_id;
        this.profile_id = profile_id;
    }
}
