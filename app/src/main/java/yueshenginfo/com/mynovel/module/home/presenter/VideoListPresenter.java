package yueshenginfo.com.mynovel.module.home.presenter;

import java.util.Map;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.home.dto.VideoListDto;
import yueshenginfo.com.mynovel.module.home.interfaces.VideoListInterface;
import yueshenginfo.com.mynovel.module.home.model.VideoListModel;
import yueshenginfo.com.mynovel.module.home.model.impl.VideoListModelImpl;
import yueshenginfo.com.mynovel.module.home.view.VideoListView;

/**
 * Created by huchao on 2016/12/28.
 * Email 1064224874@qq.com
 */
public class VideoListPresenter extends IBasePresenter<VideoListView> implements VideoListInterface {
    private VideoListModel mVideoListModel;

    public VideoListPresenter(VideoListView videoListView) {
        super(videoListView);
    }

    @Override
    public void initialized() {
        mVideoListModel = new VideoListModelImpl();
    }

    public void getVideoList(Map<String,Object> params) {
        mVideoListModel.getVideoList(params, VideoListPresenter.this);
    }

    @Override
    public void getVideoListResult(boolean isOk, VideoListDto dto) {
        getView().getVideoListResult(isOk, dto);
    }
}
