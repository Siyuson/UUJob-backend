package com.backend.uujob.controller.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class ApplicationDTO {
    private int profile_id;
    private int recruittable_id;
    private Date date;

    public ApplicationDTO(int profile_id, int recruittable_id, Date date) {
        this.profile_id = profile_id;
        this.recruittable_id = recruittable_id;
        this.date = date;
    }
}
