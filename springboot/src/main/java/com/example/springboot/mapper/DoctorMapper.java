package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.entity.Doctor;
import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorMapper {

    List<Doctor> list();

    List<Doctor> listByCondition(BaseRequest baseRequest);

    void save(Doctor obj);

    Doctor getById(Integer d_id);

    void updateById(Doctor obj);

    void deleteById(Integer d_id);
}
