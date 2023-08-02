package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.ProjectCenterRequest;
import com.example.springboot.entity.ProjectCenter;
import com.example.springboot.service.ProjectCenterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/project")
public class ProjectCenterController {

    @Autowired
    ProjectCenterService projectCenterService;

    //总查询
    @GetMapping("/list")
    public Result list(){
        List<ProjectCenter> projectCenters = projectCenterService.list();
        return Result.success(projectCenters);
    }

}
