package com.backend.uujob.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "seeker")
public class Seeker extends User{

    public Seeker(Integer id, String account, String password, String name, String phone) {
        super(id, account, password, name, phone, (short)0);
    }
}
