package yueshenginfo.com.mynovel.module.home.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Map;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.home.dto.VideoListDto;
import yueshenginfo.com.mynovel.module.home.interfaces.VideoListInterface;
import yueshenginfo.com.mynovel.module.home.model.VideoListModel;

/**
 * Created by huchao on 2016/12/28.
 * Email 1064224874@qq.com
 */
public class VideoListModelImpl extends IBaseModel implements VideoListModel {
    private VideoListInterface mVideoListInterface;

    @Override
    public void getVideoList(Map<String,Object> params, Object obj) {
        mVideoListInterface = (VideoListInterface) obj;
        mRequestManager.requestVideoList(params, new Response.Listener<VideoListDto>() {
            @Override
            public void onResponse(VideoListDto videoListDto) {
                mVideoListInterface.getVideoListResult(true, videoListDto);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mVideoListInterface.getVideoListResult(false, null);
            }
        });
    }
}
