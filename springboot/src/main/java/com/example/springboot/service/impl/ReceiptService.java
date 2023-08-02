package com.example.springboot.service.impl;

import com.example.springboot.exception.ServiceException;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.Medicinal;
import com.example.springboot.entity.Receipt;
import com.example.springboot.mapper.MedicinalMapper;
import com.example.springboot.mapper.ReceiptMapper;
import com.example.springboot.service.IReceiptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
//service的作用就是聚合业务，将业务放到service里面写

@Slf4j
@Service
@Transactional
public class ReceiptService implements IReceiptService {
    @Autowired
    MedicinalMapper medicinalMapper;

    @Autowired
    ReceiptMapper receiptMapper;
    @Override
    public List<Receipt> list() {
        return receiptMapper.list();
    }

    @Override
    public PageInfo<Receipt> page(BaseRequest baseRequest){
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Receipt> receipts = receiptMapper.listByCondition(baseRequest);
        return new PageInfo<>(receipts);
    }

    @Override
    public void save(Receipt obj) {

        Receipt receipt = obj;
        Integer receiptid = obj.getId();

        Medicinal medicinalid = medicinalMapper.getById(receiptid);

        //验证数量
        Medicinal medicinal = medicinalMapper.getByNumber(obj.getM_number());
        System.out.println("当前receiptid"+receiptid);
        System.out.println("当前medicinalid"+medicinalid);
        System.out.println("当前medicinal"+medicinal);

        if (Objects.isNull(medicinal)){
            throw new ServiceException("所需药物不存在");
        }
        Integer qty = medicinal.getM_qty();
        Integer source =receipt.getR_number();
        if (source > qty){
            throw new ServiceException("所需药物不足");
        }
        System.out.println("当前medicinal.getM_qty"+medicinal.getM_qty());
        System.out.println("当前medicinal.getM_id" + medicinal.getM_id());
        //更新数据
        medicinal.setM_qty(medicinal.getM_qty() - source);
        medicinalMapper.updateById(medicinal);
        //卡号
        receiptMapper.save(obj);
    }

    @Override
    public Receipt getById(Integer id) {
        return receiptMapper.getById(id);
    }

    @Override
    public void update(Receipt obj) {
        receiptMapper.updateById(obj);
    }

    @Override
    public void deleteById(Integer id) {
        receiptMapper.deleteById(id);
    }


}

