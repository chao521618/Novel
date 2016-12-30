package yueshenginfo.com.mynovel.module.morenovel.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.widget.SpringView;

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
import yueshenginfo.com.mynovel.module.morenovel.dto.RefushLoadmoreEvent;

/**
 * Created by huchao on 2016/12/9.
 * Email 1064224874@qq.com
 */
public class NewBooksFragment extends IBaseFragment {
    private RecyclerView mRecyclerView;
    private MoreNovelAdapter mMoreNovelAdapter;
    private List<BooksDto.BooksVO> mBooksVOArrayList;

    private SpringView mSpringView;
    private int start;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.more_novel_layout, container, false);
        EventBus.getDefault().register(this);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSpringView = getViewById(R.id.springview);
        mRecyclerView = getViewById(R.id.more_novel_rv);
        initViews();
        initDatas();

    }

    @Override
    public void initViews() {
        start=0;
        mBooksVOArrayList = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mMoreNovelAdapter = new MoreNovelAdapter(mContext, mBooksVOArrayList);
        mRecyclerView.setAdapter(mMoreNovelAdapter);
        initRefushLoadmore();
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
        if (mCategoryEvent.flag==0){
            mBooksVOArrayList.clear();
        }
        for (BooksDto.BooksVO mBooksVO : mCategoryEvent.mBooksDto) {
            mBooksVOArrayList.add(mBooksVO);
        }
        mMoreNovelAdapter.notifyDataSetChanged();
    }

    /**
     * 上啦加载更多下拉刷新
     */
    private void initRefushLoadmore() {
        mSpringView.setType(SpringView.Type.FOLLOW);
        mSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSpringView.onFinishFreshAndLoad();
                    }
                }, 500);
            }

            @Override
            public void onLoadmore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        start += 20;
                        EventBus.getDefault().post(new RefushLoadmoreEvent(start));
                        mSpringView.onFinishFreshAndLoad();
                    }
                }, 500);
            }
        });
        mSpringView.setFooter(new DefaultFooter(mContext));
    }

}
