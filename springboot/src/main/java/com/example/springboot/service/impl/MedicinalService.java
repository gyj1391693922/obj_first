package com.example.springboot.service.impl;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Medicinal;
import com.example.springboot.entity.Receipt;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.MedicinalMapper;
import com.example.springboot.mapper.ReceiptMapper;
import com.example.springboot.service.IMedicinalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
//service的作用就是聚合业务，将业务放到service里面写

@Slf4j
@Service
@Transactional
public class MedicinalService implements IMedicinalService {

    @Autowired
    MedicinalMapper medicinalMapper;


    @Override
    public List<Medicinal> list() {
        return medicinalMapper.list();
    }

    @Override
    public PageInfo<Medicinal> page(BaseRequest baseRequest){
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Medicinal> medicinals = medicinalMapper.listByCondition(baseRequest);
        return new PageInfo<>(medicinals);
    }

    @Override
    @Transactional
    public void save(Medicinal obj) {
        //卡号
        medicinalMapper.save(obj);
    }

    @Override
    public Medicinal getById(Integer d_id) {
        return medicinalMapper.getById(d_id);
    }

    @Override
    public void update(Medicinal obj) {
        medicinalMapper.updateById(obj);
    }

    @Override
    public void deleteById(Integer d_id) {
        medicinalMapper.deleteById(d_id);
    }


}

