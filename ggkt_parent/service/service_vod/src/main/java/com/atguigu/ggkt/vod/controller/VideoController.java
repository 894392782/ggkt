package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.model.vod.Video;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.VideoService;
import com.atguigu.ggkt.vod.service.VodService;
import com.atguigu.ggkt.vod.utils.ConstantPropertiesUtil;
import com.atguigu.ggkt.vod.utils.Signature;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author hc
 * @since 2022-07-07
 */
@RestController
@RequestMapping("/admin/vod/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private VodService vodService;

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Video video = videoService.getById(id);
        return Result.ok(video);
    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result save(@RequestBody Video video) {
        videoService.save(video);
        return Result.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result updateById(@RequestBody Video video) {
        videoService.updateById(video);
        return Result.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        videoService.removeVideoById(id);
        return Result.ok(null);
    }

/*    @DeleteMapping("remove/{fileId}")
    public Result remove(@PathVariable String fileId){
        vodService.removeVideo(fileId);
        return Result.ok(null);
    }*/


}

