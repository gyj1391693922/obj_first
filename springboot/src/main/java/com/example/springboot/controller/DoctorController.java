package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.DoctorPageRequest;
import com.example.springboot.entity.Doctor;
import com.example.springboot.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    IDoctorService doctorService;

    //总查询
    @GetMapping("/list")
    public Result list(){
        List<Doctor> doctors = doctorService.list();
        return Result.success(doctors);
    }
    //修改查询
    @GetMapping("/{d_id}")
    public Result getById(@PathVariable Integer d_id){
        Doctor doctor = doctorService.getById(d_id);
        return Result.success(doctor);
    }
        //增加
    @PostMapping("/save")
    public Result save(@RequestBody Doctor obj){

        doctorService.save(obj);
        return Result.success();
    }
        //修改
    @PostMapping("/update")
    public Result update(@RequestBody Doctor obj){
        doctorService.update(obj);
        return Result.success();
    }
        //删除
    @DeleteMapping("/del/{d_id}")
    public Result del(@PathVariable Integer d_id){
        doctorService.deleteById(d_id);
        return Result.success();
    }
        //
    @GetMapping("/page")
    public Result page(DoctorPageRequest doctorPageRequest){
        return Result.success(doctorService.page(doctorPageRequest
        ));
    }
}
