package com.example.springboot.service.impl;

import cn.hutool.core.date.DateUtil;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.entity.Doctor;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.DoctorMapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.IDoctorService;
import com.example.springboot.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
//service的作用就是聚合业务，将业务放到service里面写

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    DoctorMapper doctorMapper;
    @Override
    public List<Doctor> list() {
        return doctorMapper.list();
    }

    @Override
    public PageInfo<Doctor> page(BaseRequest baseRequest){
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Doctor> doctors = doctorMapper.listByCondition(baseRequest);
        return new PageInfo<>(doctors);
    }

    @Override
    public void save(Doctor obj) {
        //卡号
        doctorMapper.save(obj);
    }

    @Override
    public Doctor getById(Integer d_id) {
        return doctorMapper.getById(d_id);
    }

    @Override
    public void update(Doctor obj) {
        doctorMapper.updateById(obj);
    }

    @Override
    public void deleteById(Integer d_id) {
        doctorMapper.deleteById(d_id);
    }


}
