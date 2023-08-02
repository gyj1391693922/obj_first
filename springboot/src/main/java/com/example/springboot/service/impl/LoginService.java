package com.example.springboot.service.impl;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Login;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.LoginMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//service的作用就是聚合业务，将业务放到service里面写

@Slf4j
@Service
public class LoginService implements com.example.springboot.service.LoginService {

    @Autowired
    LoginMapper loginMapper;
    @Override
    public LoginDTO login(LoginRequest request) {
            Login admin = loginMapper.getByUsernameAndPassword(request);
            if (admin == null){
                throw new ServiceException("用户名或密码错误");
            }

            LoginDTO loginDTO = new LoginDTO();

            BeanUtils.copyProperties(admin,loginDTO);

            return loginDTO;
    }


}

