package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.entity.User;
import com.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    //总查询
    @GetMapping("/list")
    public Result list(){
        List<User> users = userService.list();
        return Result.success(users);
    }
    //修改查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        User user = userService.getById(id);
        return Result.success(user);
    }

    @PostMapping("/save")
    public Result save(@RequestBody User user){
        userService.save(user);
        return Result.success();
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user){
        userService.update(user);
        return Result.success();
    }

    @DeleteMapping("/del/{id}")
    public Result del(@PathVariable Integer id){
        userService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/page")
    public Result page(UserPageRequest userPageRequest){
        return Result.success(userService.page(userPageRequest));
    }
}
