package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class ProjectCenter {
    //项目id
    private String ProjectID;

    //项目名称
    private String ProjectTitle;

    //项目金额
    private Long renmingMoney;

    //招募类型
    private String recruit;

    //项目类型
    private String ProjectType;

    //周期
    private Integer ProjectDays;

    //报名人数
    private Long pepo;

    private Integer id;

}
