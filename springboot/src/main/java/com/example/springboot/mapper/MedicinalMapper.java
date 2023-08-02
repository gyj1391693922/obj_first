package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Medicinal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MedicinalMapper {

    List<Medicinal> list();

    List<Medicinal> listByCondition(BaseRequest baseRequest);

    void save(Medicinal obj);

    Medicinal getById(Integer d_id);

    void updateById(Medicinal obj);

    void deleteById(Integer d_id);

    Medicinal getByNumber(Long m_number);
}
