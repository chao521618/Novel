package yueshenginfo.com.mynovel.module.home.view;

import yueshenginfo.com.IBaseView;
import yueshenginfo.com.mynovel.module.home.dto.VideoListDto;

/**
 * Created by huchao on 2016/12/28.
 * Email 1064224874@qq.com
 */
public interface VideoListView extends IBaseView {
    /**
     * 请求视频列表
     * @param isOk
     * @param dto
     */
    public void getVideoListResult(boolean isOk, VideoListDto dto);
}
