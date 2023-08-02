package com.example.springboot.service;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Medicinal;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IMedicinalService {

    List<Medicinal> list();

    PageInfo<Medicinal> page(BaseRequest baseRequest);

    void save(Medicinal obj);

    Medicinal getById(Integer m_id);

    void update(Medicinal obj);

    void deleteById(Integer m_id);

}
