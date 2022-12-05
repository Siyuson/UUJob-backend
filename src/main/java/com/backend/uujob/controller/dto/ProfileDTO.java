package com.backend.uujob.controller.dto;

import lombok.Data;

@Data
public class ProfileDTO {
    private Integer id;
    private short age;
    private String sex;
    private String email;
    private Integer seeker_id;
    private short edu;
    private String description;
}
