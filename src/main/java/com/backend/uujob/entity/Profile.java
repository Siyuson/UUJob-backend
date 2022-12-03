package com.backend.uujob.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "profile")
public class Profile implements Serializable {
    @TableId
    private Integer id;
    private short age;
    private String sex;
    private String email;
    private Integer seekerId;
    private short edu;
    private String description;

    public Profile(Integer id, short age, String sex, String email, Integer seekerId, short edu, String description) {
        this.id = id;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.seekerId = seekerId;
        this.edu = edu;
        this.description = description;
    }

}
