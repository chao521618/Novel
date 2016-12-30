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
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.news.activity.NewsDetailActivity;
import yueshenginfo.com.mynovel.module.news.adapter.NewsListAdapter;
import yueshenginfo.com.mynovel.module.news.dto.HeadsNewsDto;
import yueshenginfo.com.mynovel.module.news.event.TypeEvent;
import yueshenginfo.com.mynovel.module.news.presenter.NewsPresenter;

/**
 * Created by huchao on 2016/12/30.
 * Email 1064224874@qq.com
 */
public class FinanceFragment extends IBaseFragment {
    private RecyclerView mRecyclerView;
    private NewsListAdapter mNewsListAdapter;
    private List<HeadsNewsDto.T1348647909107Dto> mArrayList;
    private NewsPresenter mNewsPresenter;
    private HeadsListFragment mHeadsListFragment;
    private int flag;


    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_item_news, container, false);
        EventBus.getDefault().register(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = getViewById(R.id.rv);
        Button button = getViewById(R.id.button);
        button.setText("---------------");
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        mArrayList = new ArrayList<>();
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

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEvent(TypeEvent mTypeEvent) {
        mArrayList.clear();
        Log.e("dD",mArrayList.toString());
        mNewsListAdapter.notifyDataSetChanged();

    }
}
