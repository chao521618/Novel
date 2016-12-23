package yueshenginfo.com.mynovel.module.review.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.review.adapter.CommunityAdapter;
import yueshenginfo.com.mynovel.module.review.dto.CommunityDto;
import yueshenginfo.com.mynovel.module.review.presenter.CommunityPresenter;
import yueshenginfo.com.mynovel.module.review.view.CommunityView;
import yueshenginfo.com.mynovel.publics.utils.T;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class CommunityFragment extends IBaseFragment implements CommunityView {
    private RecyclerView rv_review;
    private SpringView mSpringView;
    private CommunityAdapter mCommunityAdapter;
    private ArrayList<CommunityDto.PostsVO> mPostsVOList;
    private int startFlag;
    private String bookId;
    private CommunityPresenter mCommunityPresenter;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_review, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        startFlag = 0;
        bookId = getArguments().getString("bookId");
        mPostsVOList = new ArrayList<>();
        mCommunityPresenter = new CommunityPresenter(this);
        initRecyclerView();
    }

    @Override
    public void initDatas() {
        getCommunity();
    }

    private void initRecyclerView() {
        rv_review.setLayoutManager(new LinearLayoutManager(mContext));
        mCommunityAdapter = new CommunityAdapter(mContext, mPostsVOList);
        rv_review.setAdapter(mCommunityAdapter);
        rv_review.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                T.showShort(mContext, mPostsVOList.get(i).getTitle());
            }
        });
        initRefushLoadmore();
    }

    /**
     * 上啦加载，下拉刷新
     */
    private void initRefushLoadmore() {
        mSpringView.setType(SpringView.Type.FOLLOW);
        mSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadmore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startFlag += 20;
                    }
                }, 1000);
                mSpringView.onFinishFreshAndLoad();
            }
        });
        mSpringView.setFooter(new DefaultFooter(mContext));
    }

    private void getCommunity() {
        showProgress();
        Map<String, Object> params = new HashMap<>();
        params.put("book", bookId);
        params.put("sort", "updated");
        params.put("type", "normal,vote");
        params.put("start", startFlag);
        params.put("limit", 20);
        mCommunityPresenter.getCommunity(params);
    }

    @Override
    public void getCommunityResult(boolean isOk, CommunityDto dto) {
        if (isOk) {
            mPostsVOList.addAll(dto.getPosts());
        }
        mCommunityAdapter.notifyDataSetChanged();
        dismissProgress();
    }
}
