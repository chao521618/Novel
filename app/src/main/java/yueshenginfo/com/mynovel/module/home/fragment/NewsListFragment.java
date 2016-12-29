package yueshenginfo.com.mynovel.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.news.adapter.NewsListAdapter;

/**
 * Created by huchao on 2016/12/28.
 * Email 1064224874@qq.com
 */
public class NewsListFragment extends IBaseFragment {
    private RecyclerView mRecyclerView;
    private NewsListAdapter mNewsListAdapter;
    private ArrayList<String> mArrayList;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_item_news, container, false);
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
        mArrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mArrayList.add(String.valueOf(i));
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mNewsListAdapter = new NewsListAdapter(mContext, mArrayList);
        mRecyclerView.setAdapter(mNewsListAdapter);
    }

    @Override
    public void initDatas() {

    }
}
