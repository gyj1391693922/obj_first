package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    LoginService loginService;


    //登录
    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest request){
        LoginDTO login = loginService.login(request);
        return Result.success(login);
    }

    //总查询
}
