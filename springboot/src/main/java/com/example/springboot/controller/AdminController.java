package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.service.IAdminService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IAdminService adminService;


    //登录
    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest request){
        LoginDTO login = adminService.login(request);
        return Result.success(login);
    }

    //总查询
    @GetMapping("/list")
    public Result list(){
        List<Admin> admins = adminService.list();
        return Result.success(admins);
    }
    //修改查询
    @GetMapping("/{d_id}")
    public Result getById(@PathVariable Integer d_id){
        Admin admin = adminService.getById(d_id);
        return Result.success(admin);
    }
        //增加
    @PostMapping("/save")
    public Result save(@RequestBody Admin obj){
        try{
            adminService.save(obj);
        }catch(Exception e){
            log.error("数据插入失败,用户名已存在或其他不可知的原因,详细请查看日志:username:{}",obj.getU_username());
            System.out.println("具体错误信息：" + e.getMessage());
            throw new ServiceException("用户插入失败");
        }

        return Result.success();
    }
        //修改
    @PostMapping("/update")
    public Result update(@RequestBody Admin obj){
        adminService.update(obj);
        return Result.success();
    }
        //删除
    @DeleteMapping("/del/{d_id}")
    public Result del(@PathVariable Integer d_id){
        adminService.deleteById(d_id);
        return Result.success();
    }
        //
    @GetMapping("/page")
    public Result page(AdminPageRequest adminPageRequest){
        return Result.success(adminService.page(adminPageRequest
        ));
    }
}
