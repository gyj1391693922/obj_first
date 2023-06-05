package com.example.springboot.common;

import lombok.Data;
//希望后台包装result数据，将数据存到result的get里面
//这是一个result的通用返回类
@Data
public class Result {
    private static final String SUCCESS_CODE = "200";
    private static final String ERROR_CODE = "-1";


    private String code;//相应结果从code体现
    private Object data;//前端从data拿数据
    private String msg;//msg存放错误信息

    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        return result;
    }

    public static Result success(Object data){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }

    public static Result error(String msg){
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);
        return result;
    }

}
