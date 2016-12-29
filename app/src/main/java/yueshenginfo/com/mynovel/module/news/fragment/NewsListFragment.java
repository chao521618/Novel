package yueshenginfo.com.mynovel.module.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.news.adapter.NewsListAdapter;
import yueshenginfo.com.mynovel.module.news.dto.NewsDto;
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
        mArrayList=new ArrayList<>();
        mNewsPresenter = new NewsPresenter(this);
        initRecyclerView();
    }
    private void initRecyclerView(){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mNewsListAdapter = new NewsListAdapter(mContext, mArrayList);
        mRecyclerView.setAdapter(mNewsListAdapter);
    }

    @Override
    public void initDatas() {
        getNews();
    }

    private void getNews() {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("0", "headline");
        params.put("1", "T1348647909107");
        params.put("2", "0-20.html");
        mNewsPresenter.getNews(params);
    }

    @Override
    public void getNewsResult(boolean isOk, NewsDto dto) {
        if (isOk) {
            if (EmptyUtils.isNotEmpty(dto.getT1348647909107())){
                mArrayList.addAll(dto.getT1348647909107());
            }
        }
        Log.e("::::::::::::::::::",dto.getT1348647909107().toString());
        mNewsListAdapter.notifyDataSetChanged();
    }
}
