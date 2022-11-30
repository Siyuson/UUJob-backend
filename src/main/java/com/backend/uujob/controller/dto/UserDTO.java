package com.backend.uujob.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserDTO {

    private Integer id;

    private String account;

    private String password;

    private String name;

    private String phone;

    private short character;

    private String company;

    private String position;

}
