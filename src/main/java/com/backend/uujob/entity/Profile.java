package com.backend.uujob.entity;


import lombok.Data;

@Data
public class Profile {
    private Integer id;
    private short age;
    private String sex;
    private String email;
    private Integer seekerId;
    private short edu;
    private String description;

    public Profile(Integer id, short age, String sex, String email, Integer seekerId, short edu, String description) {
        this.id = id;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.seekerId = seekerId;
        this.edu = edu;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(Integer seekerId) {
        this.seekerId = seekerId;
    }

    public short getEdu() {
        return edu;
    }

    public void setEdu(short edu) {
        this.edu = edu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
