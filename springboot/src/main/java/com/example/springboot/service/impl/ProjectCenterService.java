package com.example.springboot.service.impl;

import com.example.springboot.entity.ProjectCenter;
import com.example.springboot.mapper.ProjectCenterMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class ProjectCenterService implements com.example.springboot.service.ProjectCenterService {

    @Autowired
    ProjectCenterMapper projectCenterMapper;

    @Override
    public List<ProjectCenter> list() {
        return projectCenterMapper.list();
    }
}
