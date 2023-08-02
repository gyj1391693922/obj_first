package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.Medicinal;
import com.example.springboot.entity.Receipt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReceiptMapper {

    List<Receipt> list();

    List<Receipt> listByCondition(BaseRequest baseRequest);

    void save(Receipt obj);

    Receipt getById(Integer id);

    void updateById(Receipt user);

    void deleteById(Integer id);


}
