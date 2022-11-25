package com.backend.uujob.entity;

public class Seeker extends User{

    public Seeker(Integer id, String account, String password, String name, String phone) {
        super(id, account, password, name, phone, (short)0);
    }
}
