package yueshenginfo.com.mynovel.module.news.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import java.util.List;
import java.util.Map;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.news.activity.NewsDetailActivity;
import yueshenginfo.com.mynovel.module.news.adapter.FinanceListAdapter;
import yueshenginfo.com.mynovel.module.news.adapter.NewsListAdapter;
import yueshenginfo.com.mynovel.module.news.dto.FinanceNewsDto;
import yueshenginfo.com.mynovel.module.news.dto.HeadsNewsDto;
import yueshenginfo.com.mynovel.module.news.event.TypeEvent;
import yueshenginfo.com.mynovel.module.news.presenter.FinancePresenter;
import yueshenginfo.com.mynovel.module.news.presenter.NewsPresenter;
import yueshenginfo.com.mynovel.module.news.view.FinanceView;
import yueshenginfo.com.mynovel.module.news.view.NewsView;

/**
 * Created by huchao on 2016/12/28.
 * Email 1064224874@qq.com
 */
public class HeadsListFragment extends IBaseFragment implements NewsView, FinanceView {
    private RecyclerView mRecyclerView;
    private NewsListAdapter mNewsListAdapter;
    private FinanceListAdapter mFinanceListAdapter;
    private List<HeadsNewsDto.T1348647909107Dto> mArrayList;
    private List<FinanceNewsDto.T1348649580692VO> mArrayList1;
    private NewsPresenter mNewsPresenter;
    private FinancePresenter mFinancePresenter;
    ;
    private HeadsListFragment mHeadsListFragment;
    private int flag;
    private String args0, args1;


    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_item_news, container, false);
        EventBus.getDefault().register(this);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv);
        initViews();
        initDatas();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void initViews() {
        mNewsPresenter = new NewsPresenter(this);
        mFinancePresenter = new FinancePresenter(this);
        mArrayList = new ArrayList<>();
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        if (flag == 0) {
            mNewsListAdapter = new NewsListAdapter(mContext, mArrayList);
        } else if (flag == 1) {
            mFinanceListAdapter = new FinanceListAdapter(mContext, mArrayList1);
        } else if (flag == 2) {
            mNewsListAdapter = new NewsListAdapter(mContext, mArrayList);
        } else if (flag == 3) {
            mNewsListAdapter = new NewsListAdapter(mContext, mArrayList);
        } else if (flag == 4) {
            mNewsListAdapter = new NewsListAdapter(mContext, mArrayList);
        }
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
        if (flag == 0) {
            args0 = "headline";
            args1 = "T1348647909107";
            getNews();
        } else if (flag == 1) {
            args0 = "list";
            args1 = "T1348649580692";
            getFinance();
        } else if (flag == 2) {
            args0 = "list";
            args1 = "T1348648756099";
            getNews();
        } else if (flag == 3) {
            args0 = "list";
            args1 = "T1348648141035";
            getNews();
        } else if (flag == 4) {
            args0 = "list";
            args1 = "T1348649079062";
            getNews();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEvent(TypeEvent mTypeEvent) {
        flag = mTypeEvent.type;
    }

    private void getNews() {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("0", args0);
        params.put("1", args1);
        params.put("2", "0-20.html");
        mNewsPresenter.getNews(params);
    }

    @Override
    public void getNewsResult(boolean isOk, HeadsNewsDto dto) {
        mArrayList.clear();
        if (isOk) {
            mArrayList.addAll(dto.getT1348647909107());
        }
        mNewsListAdapter.notifyDataSetChanged();
    }

    private void getFinance() {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("0", args0);
        params.put("1", args1);
        params.put("2", "0-20.html");
        mFinancePresenter.getFinance(params);
    }

    @Override
    public void getFinanceResult(boolean isOk, FinanceNewsDto dto) {
        mArrayList1.clear();
        if (isOk) {
            mArrayList1.addAll(dto.getT1348649580692());
        }
        mFinanceListAdapter.notifyDataSetChanged();
    }


}
