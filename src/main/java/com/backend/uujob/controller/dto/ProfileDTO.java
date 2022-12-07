package com.backend.uujob.controller.dto;

import lombok.Data;

@Data
public class ProfileDTO {
    private Integer id;
    private short age;
    private String sex;
    private String email;
    private String edu;
    private String description;
}
