package com.backend.uujob.entity;

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
    private Integer publisherId;
    private String position;
    private String salary;
    private Date date;
    private short status;
    private String description;

    public RecruitTable(Integer id, Integer publisherId, String position, String salary, Date date, String description) {
        this.id = id;
        this.publisherId = publisherId;
        this.position = position;
        this.salary = salary;
        this.date = date;
        this.description = description;
        this.status = 0;
    }
    public RecruitTable(){
        ;
    }
    public RecruitTable(Integer id){
        this.publisherId = id;
        this.status = 0;
    }
}