package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.VideoVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 视频来访者记录表 前端控制器
 * </p>
 *
 * @author hc
 * @since 2022-07-08
 */
@RestController
@RequestMapping("/admin/vod/videoVisitor")
public class VideoVisitorController {

    @Autowired
    private VideoVisitorService videoVisitorService;

    @GetMapping("findCount/{courseId}/{startDate}/{endDate}")
    public Result findCount(@PathVariable Long courseId,@PathVariable String startDate,@PathVariable String endDate){
        Map<String,Object> map = videoVisitorService.findCount(courseId,startDate,endDate);
        return Result.ok(map);
    }
}

