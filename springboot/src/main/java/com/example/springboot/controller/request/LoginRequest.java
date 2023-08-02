package com.example.springboot.controller.request;


import lombok.Data;

//登录请求类
@Data
public class LoginRequest extends BaseRequest{
    private String userName;
    private String passWord;

}
