package com.backend.uujob.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "application")
public class Application implements Serializable {
    private Integer profileId;
    private Integer recruittableId;
    private DateTime date;
    public Application(Integer profileId,Integer recruittableId,DateTime date) {
        this.profileId = profileId;
        this.recruittableId = recruittableId;
        this.date = date;
    }

}
