package com.backend.uujob.entity;

import java.util.Date;

public class RecruitTable {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getStatus() {
        return status;
    }
}
