package com.example.springboot.controller.dto;


import lombok.Data;

//封装返回数据
@Data
public class LoginDTO {
    private String userName;

    private String passWord;
}
