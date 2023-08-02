package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class MedicinalPageRequest extends BaseRequest{
    private String m_number;
    private String m_name;

}
