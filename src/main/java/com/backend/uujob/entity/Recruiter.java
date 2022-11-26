package com.backend.uujob.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "recruiter")
public class Recruiter extends User{
    private String company;
    private String position;

    public Recruiter(Integer id, String account, String password, String name, String phone) {
        super(id, account, password, name, phone, (short) 1);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
