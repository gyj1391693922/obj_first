package com.example.springboot.exception;

import com.example.springboot.common.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler(value = ServiceException.class)
    public Result serviceexceptionError(ServiceException e){
        log.error("业务异常",e);
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result exceptionError(Exception e){
        log.error("系统错误",e);
        return Result.error("系统错误");
    }

}
