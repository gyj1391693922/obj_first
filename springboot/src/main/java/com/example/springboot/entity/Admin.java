package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Admin {
    private Integer u_id;

    private String u_username;

    private String u_password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date u_createTime;

    private String u_name;

    private String u_idCard;

    private String u_address;

    private String u_phone;

    private Long u_money;
}
