package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class DoctorPageRequest extends BaseRequest{
    private String name;
    private String phone;
    private String d_leve;

}
