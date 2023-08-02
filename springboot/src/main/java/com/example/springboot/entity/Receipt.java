package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Receipt {
    /**
     * @description 用户信息
     * @author zhengkai.blog.csdn.net
     * @date 2023-06-08
     */

    private Integer id;

    private String m_name;

    private Long m_number;

    private String u_name;

    private String m_amount;

    private String u_phone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date r_createtime;

    private Integer r_number;

    private String r_comment;


}
