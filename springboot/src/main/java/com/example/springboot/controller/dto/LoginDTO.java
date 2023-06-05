package com.example.springboot.controller.dto;


import lombok.Data;

//封装返回数据
@Data
public class LoginDTO {
    private String u_username;

    private String u_phone;

    private Long u_money;
}
