package com.example.springboot.service.impl;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.AdminMapper;
import com.example.springboot.service.IAdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//service的作用就是聚合业务，将业务放到service里面写

@Slf4j
@Service
public class AdminService implements IAdminService {

    @Autowired
    AdminMapper adminMapper;
    @Override
    public List<Admin> list() {
        return adminMapper.list();
    }

    @Override
    public PageInfo<Admin> page(BaseRequest baseRequest){
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Admin> admins = adminMapper.listByCondition(baseRequest);
        return new PageInfo<>(admins);
    }

    @Override
    public void save(Admin obj) {
        //卡号
        adminMapper.save(obj);
    }

    @Override
    public Admin getById(Integer d_id) {
        return adminMapper.getById(d_id);
    }

    @Override
    public void update(Admin obj) {
        adminMapper.updateById(obj);
    }

    @Override
    public void deleteById(Integer d_id) {
        adminMapper.deleteById(d_id);
    }

    @Override
    public LoginDTO login(LoginRequest request) {
            Admin admin = adminMapper.getByUsernameAndPassword(request);
            if (admin == null){
                throw new ServiceException("用户名或密码错误");
            }

            LoginDTO loginDTO = new LoginDTO();

            BeanUtils.copyProperties(admin,loginDTO);

            return loginDTO;
    }


}

