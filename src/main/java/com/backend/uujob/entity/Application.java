package com.backend.uujob.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.Data;
import java.util.Date;

@Data
@TableName(value = "application")
public class Application {

    @MppMultiId
    @TableField(value="profile_id")
    private int profile_id;
    @MppMultiId
    @TableField(value="recruittable_id")
    private int recruittable_id;
    private Date date;

    public Application(int profile_id, int recruittable_id, Date date) {
        this.profile_id = profile_id;
        this.recruittable_id = recruittable_id;
        this.date = date;
    }
}
