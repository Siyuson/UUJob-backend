package com.backend.uujob.controller.dto;

import lombok.Data;

import java.sql.Date;
@Data
public class ProfileDTO {
    Integer id;
    Short age;
    String sex;
    String email;
    Integer seekerid;
    Short edu;
    String description;
}
