package com.backend.uujob.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@TableName(value = "recruittable")
public class RecruitTable  implements Serializable {
    @TableId
    private Integer id;
    private String title;
    private String position;
    private String salary;
    private Date date;
    private short status;
    private String description;

    public RecruitTable(Integer id, String title, String position, String salary, Date date, short status, String description) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.salary = salary;
        this.date = date;
        this.description = description;
        this.status = status;
    }

    public RecruitTable(String title, String position, String salary, Date date, short status, String description) {
        this.title = title;
        this.position = position;
        this.salary = salary;
        this.date = date;
        this.status = status;
        this.description = description;
    }

    public RecruitTable(){
        this.id = 0;//自动递增而不指定
        this.date = new Date();//当前时间
        this.status = 0;
    }
}
