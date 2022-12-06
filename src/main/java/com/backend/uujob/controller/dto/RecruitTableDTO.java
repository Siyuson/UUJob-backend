package com.backend.uujob.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RecruitTableDTO {
    private Integer id;
    private String title;
    private String position;
    private String salary;
    private Date date;
    private String description;

}
