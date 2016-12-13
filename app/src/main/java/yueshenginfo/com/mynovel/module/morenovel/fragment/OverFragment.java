package yueshenginfo.com.mynovel.module.morenovel.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.dto.CategoryEvent;
import yueshenginfo.com.mynovel.module.morenovel.adapter.MoreNovelAdapter;
import yueshenginfo.com.mynovel.module.morenovel.dto.BooksDto;

/**
 * Created by huchao on 2016/12/13.
 * Email 1064224874@qq.com
 */
public class OverFragment extends IBaseFragment {
    private RecyclerView mRecyclerView;
    private MoreNovelAdapter mMoreNovelAdapter;
    private List<BooksDto.BooksVO> mBooksVOArrayList;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.more_novel_layout, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.more_novel_rv);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        initDatas();
        EventBus.getDefault().register(this);
    }

    @Override
    public void initViews() {
        mBooksVOArrayList = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mMoreNovelAdapter = new MoreNovelAdapter(mContext, mBooksVOArrayList);
        mRecyclerView.setAdapter(mMoreNovelAdapter);
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
    public void event(CategoryEvent mCategoryEvent) {
        mBooksVOArrayList.clear();
        for (BooksDto.BooksVO mBooksVO : mCategoryEvent.mBooksDto) {
            mBooksVOArrayList.add(mBooksVO);
        }
        mMoreNovelAdapter.notifyDataSetChanged();
    }
}
