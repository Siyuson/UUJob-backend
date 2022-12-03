package com.backend.uujob.controller.dto;

import lombok.Data;

import java.util.Date;
public class RecruitTableDTO {
    private Integer id;
    private String position;
    private String salary;
    private Date date;
    private short status;
    private String description;

}
