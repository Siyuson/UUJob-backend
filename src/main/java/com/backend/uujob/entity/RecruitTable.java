package com.backend.uujob.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class RecruitTable  implements Serializable {

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
    }
}