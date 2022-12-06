package com.backend.uujob.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "recruit")
public class Recruit {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer recruiter_id;
    private Integer recruittable_id;

    public Recruit(Integer id, Integer recruiter_id, Integer recruittable_id) {
        this.id = id;
        this.recruiter_id = recruiter_id;
        this.recruittable_id = recruittable_id;
    }
}
