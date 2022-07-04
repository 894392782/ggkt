package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author hc
 * @since 2022-07-04
 */
@Api(tags = "讲师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    //http://localhost:8301/admin/vod/teacher/findAll
    //查询所有讲师
    @GetMapping("findAll")
    @ApiOperation("查询所有讲师")
    public List<Teacher> findAllTeacher(){
        //调用service方法
        List<Teacher> list = teacherService.list();
        return list;
    }
    //逻辑删除讲师
    @DeleteMapping("remove/{id}")
    @ApiOperation("逻辑删除讲师")
    public boolean removeTeacher(@PathVariable Long id){
        boolean isSuccess = teacherService.removeById(id);
        return isSuccess;
    }
}

