package com.example.springboot.controller.request;


import lombok.Data;

//登录请求类
@Data
public class LoginRequest {
    private String u_username;
    private String u_password;

}
