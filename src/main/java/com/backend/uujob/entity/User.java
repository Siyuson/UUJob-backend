package com.backend.uujob.entity;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String account;
    private String password;
    private String name;
    private String phone;
    private short character;

    public User(Integer id, String account, String password, String name, String phone, short character) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.character = character;
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

    public short getCharacter() {
        return character;
    }

}
