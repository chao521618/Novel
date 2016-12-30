package yueshenginfo.com.mynovel.module.news.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.news.activity.NewsDetailActivity;
import yueshenginfo.com.mynovel.module.news.adapter.NewsListAdapter;
import yueshenginfo.com.mynovel.module.news.dto.HeadsNewsDto;
import yueshenginfo.com.mynovel.module.news.presenter.NewsPresenter;
import yueshenginfo.com.mynovel.module.news.view.NewsView;
import yueshenginfo.com.mynovel.publics.utils.EmptyUtils;

/**
 * Created by huchao on 2016/12/30.
 * Email 1064224874@qq.com
 */
public class ScienceFragment extends IBaseFragment implements NewsView {
    private RecyclerView mRecyclerView;
    private NewsListAdapter mNewsListAdapter;
    private List<HeadsNewsDto.T1348647909107Dto> mArrayList;
    private NewsPresenter mNewsPresenter;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_item_news, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv);
        initViews();
        initDatas();
        return view;
    }
    public static Fragment getInstence() {
        HeadsListFragment mNewsListFragment = new HeadsListFragment();
        return mNewsListFragment;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void initViews() {
        mArrayList = new ArrayList<>();
        initRecyclerView();
        mNewsPresenter = new NewsPresenter(this);
    }
    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mNewsListAdapter = new NewsListAdapter(mContext, mArrayList);
        mRecyclerView.setAdapter(mNewsListAdapter);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Intent mIntent = new Intent(mContext, NewsDetailActivity.class);
                startActivity(mIntent);
            }
        });
    }

    @Override
    public void initDatas() {
    getNews();

}

//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void getEvent(TypeEvent mTypeEvent) {
//        mArrayList.clear();
//        Log.e("22222222", mTypeEvent.mArrayList.toString());
//        for (HeadsNewsDto.T1348647909107Dto dto : mTypeEvent.mArrayList) {
//            mArrayList.add(dto);
//        }
//        mNewsListAdapter.notifyDataSetChanged();
//    }

    private void getNews() {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("0", "list");
        params.put("1", "T1348649580692");
        params.put("2", "0-20.html");
        mNewsPresenter.getNews(params);
    }

    @Override
    public void getNewsResult(boolean isOk, HeadsNewsDto dto) {
        mArrayList.clear();
        if (isOk) {
            if (EmptyUtils.isNotEmpty(dto.getT1348647909107())) {
                mArrayList.addAll(dto.getT1348647909107());
            }
            mNewsListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        initDatas();
    }
}
