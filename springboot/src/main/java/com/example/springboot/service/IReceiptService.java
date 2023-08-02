package com.example.springboot.service;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Receipt;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IReceiptService {

    List<Receipt> list();

    PageInfo<Receipt> page(BaseRequest baseRequest);

    void save(Receipt obj);

    Receipt getById(Integer id);

    void update(Receipt obj);

    void deleteById(Integer id);
}
