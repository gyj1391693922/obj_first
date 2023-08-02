package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.ReceiptPageRequest;
import com.example.springboot.entity.Receipt;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.service.IReceiptService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/receipt")
public class ReceiptController {

    @Autowired
    IReceiptService receiptService;


    //总查询
    @GetMapping("/list")
    public Result list(){
        List<Receipt> receipts = receiptService.list();
        return Result.success(receipts);
    }
    //修改查询
    @GetMapping("/{d_id}")
    public Result getById(@PathVariable Integer d_id){
        Receipt receipt = receiptService.getById(d_id);
        return Result.success(receipt);
    }
        //增加
    @PostMapping("/save")
    public Result save(@RequestBody Receipt obj){
            receiptService.save(obj);

        return Result.success();
    }
        //修改
    @PostMapping("/update")
    public Result update(@RequestBody Receipt obj){
        receiptService.update(obj);
        return Result.success();
    }
        //删除
    @DeleteMapping("/del/{d_id}")
    public Result del(@PathVariable Integer d_id){
        receiptService.deleteById(d_id);
        return Result.success();
    }
        //
    @GetMapping("/page")
    public Result page(ReceiptPageRequest receiptPageRequest){
        return Result.success(receiptService.page(receiptPageRequest
        ));
    }
}
