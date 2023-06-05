package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Doctor {
    private Integer d_id;

    private String d_name;

    private String d_phone;

    private String d_leve;

    private String d_money;

    private String d_educational;

    private String d_profession;

    private String d_age;

    private String d_sex;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date d_createTime;

    private Integer d_uid;
}
