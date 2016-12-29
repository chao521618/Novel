package yueshenginfo.com.mynovel.module.news.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.news.activity.NewsDetailActivity;
import yueshenginfo.com.mynovel.module.news.adapter.NewsListAdapter;
import yueshenginfo.com.mynovel.module.news.dto.NewsDto;
import yueshenginfo.com.mynovel.module.news.event.TypeEvent;
import yueshenginfo.com.mynovel.module.news.presenter.NewsPresenter;
import yueshenginfo.com.mynovel.module.news.view.NewsView;
import yueshenginfo.com.mynovel.publics.utils.EmptyUtils;

/**
 * Created by huchao on 2016/12/28.
 * Email 1064224874@qq.com
 */
public class NewsListFragment extends IBaseFragment implements NewsView {
    private RecyclerView mRecyclerView;
    private NewsListAdapter mNewsListAdapter;
    private ArrayList<NewsDto.T1348647909107Dto> mArrayList;
    private NewsPresenter mNewsPresenter;
    private int typeFlag;
    private String args0, args1;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_item_news, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = getViewById(R.id.rv);
        EventBus.getDefault().register(this);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        mArrayList = new ArrayList<>();
        mNewsPresenter = new NewsPresenter(this);
        initRecyclerView();
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
        Log.e("111111111", String.valueOf(typeFlag));
        if (typeFlag == 0) {
            args0 = "headline";
            args1 = "T1348647909107";
        } else if (typeFlag == 1) {
            args0 = "list";
            args1 = "T1348649580692";
        } else if (typeFlag == 2) {
            args0 = "list";
            args1 = "T1348648756099";
        } else if (typeFlag == 3) {
            args0 = "list";
            args1 = "T1348648141035";
        } else if (typeFlag == 4) {
            args0 = "list";
            args1 = "T1348649079062";
        }
        getNews();
    }

    private void getNews() {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("0", args0);
        params.put("1", args1);
        params.put("2", "0-20.html");
        mNewsPresenter.getNews(params);
    }

    @Override
    public void getNewsResult(boolean isOk, NewsDto dto) {
        if (isOk) {
            if (EmptyUtils.isNotEmpty(dto.getT1348647909107())) {
                mArrayList.addAll(dto.getT1348647909107());
            }
        }
        mNewsListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().register(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEvent(TypeEvent typeEvent) {
        typeFlag = typeEvent.type;
    }
}
