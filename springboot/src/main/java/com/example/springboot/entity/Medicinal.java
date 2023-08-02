package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Medicinal {
    private Integer m_id;

    private Long m_number;

    private String m_name;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date m_create_time;

    private Integer m_qty;

    private String m_content;

    private double m_price;

}
