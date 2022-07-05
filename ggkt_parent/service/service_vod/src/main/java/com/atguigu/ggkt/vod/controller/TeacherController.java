package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
    /*@GetMapping("findAll")
    @ApiOperation("查询所有讲师")
    public List<Teacher> findAllTeacher(){
        //调用service方法
        List<Teacher> list = teacherService.list();
        return list;
    }*/

    @GetMapping("findAll")
    @ApiOperation("查询所有讲师")
    public Result findAllTeacher(){
        //调用service方法
        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询数据成功");
    }

    //逻辑删除讲师
    @DeleteMapping("remove/{id}")
    @ApiOperation("逻辑删除讲师")
    public Result removeTeacher(@PathVariable Long id){
        boolean isSuccess = teacherService.removeById(id);
        if (isSuccess){
            return Result.ok(null).message("删除成功");
        }else {
            return Result.fail(null).message("删除失败");
        }
    }

    //条件查询分页
    @ApiOperation("条件查询分页")
    @PostMapping("findQueryPage/{current}/{limit}")
    public Result findPage(@ PathVariable long current, @PathVariable long limit,
                           @RequestBody(required = false) TeacherQueryVo teacherQueryVo){
        //创建page对象
        Page<Teacher> pageParam = new Page<>(current,limit);
        //判断teacherQueryVO是否为空
        if (teacherQueryVo == null){
            IPage<Teacher> pageModel = teacherService.page(pageParam,null);
            return Result.ok(pageModel);
        }else {
            //获取条件值。进行非空判断，封装
            String name = teacherQueryVo.getName();
            Integer level = teacherQueryVo.getLevel();
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();

            QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
            if (!StringUtils.isEmpty(name)){
                wrapper.like("name",name);
            }
            if (!StringUtils.isEmpty(level)){
                wrapper.like("name",level);
            }
            if (!StringUtils.isEmpty(joinDateBegin)){
                wrapper.ge("name",joinDateBegin);
            }
            if (!StringUtils.isEmpty(level)){
                wrapper.le("name",joinDateEnd);
            }
            //调用方法分页查询

            IPage<Teacher> pageModel = teacherService.page(pageParam, wrapper);
            return Result.ok(pageModel);
        }
    }

    //添加讲师
    @ApiOperation("添加讲师")
    @PostMapping("saveTeacher")
    public  Result saveTeacher(@RequestBody Teacher teacher){
        boolean isSuccess = teacherService.save(teacher);
        if (isSuccess){
            return Result.ok(null).message("添加成功");
        }else {
            return Result.fail(null).message("添加失败");
        }
    }

    //修改
    @ApiOperation("根据id查询")
    @GetMapping("getTeacher/{id}")
    public Result getTeacher(@PathVariable Long id){
        Teacher teacher = teacherService.getById(id);
        return Result.ok(teacher);
    }

    @ApiOperation("修改的最终实现")
    @PostMapping("updateTeacher")
    public Result updateTeacher(@RequestBody Teacher teacher){
        boolean isSuccess = teacherService.updateById(teacher);
        System.out.println(isSuccess);
        if (isSuccess){
            return Result.ok(null).message("修改成功");
        }else {
            return Result.fail(null).message("修改失败");
        }
    }

    //批量删除
    //以json数组格式传递
    @ApiOperation("批量删除讲师")
    @DeleteMapping("removeBatch")
    public Result removeBatch(@RequestBody List<Long> idList){
        boolean isSuccess = teacherService.removeByIds(idList);
        if (isSuccess){
            return Result.ok(null).message("删除成功");
        }else {
            return Result.fail(null).message("删除失败");
        }
    }
}

















