package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class AdminPageRequest extends BaseRequest{
    private String u_username;
    private String u_idCard;

}
