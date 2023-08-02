package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.MedicinalPageRequest;
import com.example.springboot.entity.Medicinal;
import com.example.springboot.service.IMedicinalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/medicinal")
public class MedicinalController {

    @Autowired
    IMedicinalService medicinalService;

    //总查询
    @GetMapping("/list")
    public Result list(){
        List<Medicinal> medicinals = medicinalService.list();
        return Result.success(medicinals);
    }
    //修改查询
    @GetMapping("/{d_id}")
    public Result getById(@PathVariable Integer d_id){
        Medicinal medicinal = medicinalService.getById(d_id);
        return Result.success(medicinal);
    }
        //增加
    @PostMapping("/save")
    public Result save(@RequestBody Medicinal obj){

        medicinalService.save(obj);
        return Result.success();
    }
        //修改
    @PostMapping("/update")
    public Result update(@RequestBody Medicinal obj){
        medicinalService.update(obj);
        return Result.success();
    }
        //删除
    @DeleteMapping("/del/{d_id}")
    public Result del(@PathVariable Integer d_id){
        medicinalService.deleteById(d_id);
        return Result.success();
    }
        //
    @GetMapping("/page")
    public Result page(MedicinalPageRequest medicinalPageRequest){
        return Result.success(medicinalService.page(medicinalPageRequest
        ));
    }
}
