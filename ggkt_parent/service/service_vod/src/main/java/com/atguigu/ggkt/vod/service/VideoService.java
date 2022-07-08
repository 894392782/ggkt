package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author hc
 * @since 2022-07-07
 */
public interface VideoService extends IService<Video> {

    void removeVideoByCourseId(Long id);
}
