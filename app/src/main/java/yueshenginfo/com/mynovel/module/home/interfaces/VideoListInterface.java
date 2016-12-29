package yueshenginfo.com.mynovel.module.home.interfaces;

import yueshenginfo.com.mynovel.module.home.dto.VideoListDto;

/**
 * Created by huchao on 2016/12/28.
 * Email 1064224874@qq.com
 */
public interface VideoListInterface {
    /**
     * 请求视频列表
     * @param isOk
     * @param dto
     */
    public void getVideoListResult(boolean isOk, VideoListDto dto);
}
