package yueshenginfo.com.mynovel.module.home.model;

import java.util.Map;

/**
 * Created by huchao on 2016/12/28.
 * Email 1064224874@qq.com
 */
public interface VideoListModel {
    /**
     * 请求视频列表
     * @param params
     * @param obj
     */
    public void getVideoList(Map<String,Object> params, Object obj);
}
