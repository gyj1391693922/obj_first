package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class ReceiptPageRequest  extends BaseRequest{
    private String u_name;

    private Integer id;

    private String u_phone;
}
