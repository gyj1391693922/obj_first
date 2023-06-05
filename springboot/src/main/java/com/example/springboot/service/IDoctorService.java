package com.example.springboot.service;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.Doctor;
import com.example.springboot.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IDoctorService {

    List<Doctor> list();

    PageInfo<Doctor> page(BaseRequest baseRequest);

    void save(Doctor obj);

    Doctor getById(Integer d_id);

    void update(Doctor obj);

    void deleteById(Integer d_id);
}
