package yueshenginfo.com.mynovel.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.adapter.OriginalAdapter;
import yueshenginfo.com.mynovel.module.home.dto.VideoListDto;
import yueshenginfo.com.mynovel.module.home.presenter.VideoListPresenter;
import yueshenginfo.com.mynovel.module.home.view.VideoListView;

/**
 * Created by huchao on 2016/11/30.
 * Email 1064224874@qq.com
 */
public class OriginalFragment extends IBaseFragment implements View.OnClickListener, VideoListView {
    private RecyclerView mRecyclerView;
    private OriginalAdapter mOriginalAdapter;
    private ArrayList<VideoListDto.V9LG4B3A0VO> mVideoTopicVOsList;
    private FrameLayout mFrameLayout;

    private VideoListPresenter mVideoListPresenter;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_original, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = getViewById(R.id.rv);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        setTitle("友记原创");
        mVideoTopicVOsList = new ArrayList<>();
        mVideoListPresenter = new VideoListPresenter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mOriginalAdapter = new OriginalAdapter(mContext, mVideoTopicVOsList);
        mRecyclerView.setAdapter(mOriginalAdapter);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
//                Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/Test_Movie.m4v");
//                VideoView videoView = (VideoView)this.findViewById(R.id.video_view);
//                videoView.setMediaController(new MediaController(this));
//                videoView.setVideoURI(uri);
//                videoView.start();
//                videoView.requestFocus();
            }
        });
    }

    @Override
    public void initDatas() {

        getVideoList();
    }

    @Override
    public void onClick(View v) {

    }

    //http://c.3g.163.com/nc/video/list/V9LG4B3A0/n/20-10.html
    private void getVideoList() {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("1", "V9LG4B3A0");
        params.put("2", "n");
        params.put("3", "0-10.html");
        mVideoListPresenter.getVideoList(params);
    }

    @Override
    public void getVideoListResult(boolean isOk, VideoListDto dto) {
        if (isOk) {
            mVideoTopicVOsList.addAll(dto.getV9LG4B3A0());
        }
        mOriginalAdapter.notifyDataSetChanged();
    }
}
