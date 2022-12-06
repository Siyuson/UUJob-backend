package com.backend.uujob.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "profile")
public class Profile implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private short age;
    private String sex;
    private String email;
    private Integer seeker_id;
    private String edu;
    private String description;

    public Profile(short age, String sex, String email, Integer seeker_id, String edu, String description) {
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.seeker_id = seeker_id;
        this.edu = edu;
        this.description = description;
    }
    public Profile(Integer seeker_id) {
        this.seeker_id = seeker_id;
    }
    public Profile() {
        ;
    }

}
