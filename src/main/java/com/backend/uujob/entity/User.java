package com.backend.uujob.entity;

import com.backend.uujob.controller.dto.UserDTO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "user")
public class User implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String account;
    @JsonIgnore
    private String password;
    private String name;
    private String phone;
    private short role;
    private String company;
    private String position;
    //mybatis-plus需要使用和数据表一致的构造函数
    public User(Integer id, String account, String password, String name, String phone, short role, String company, String position) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.role = role;
        this.company = company;
        this.position = position;
    }

    public User() {
        ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getRole() {
        return role;
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
