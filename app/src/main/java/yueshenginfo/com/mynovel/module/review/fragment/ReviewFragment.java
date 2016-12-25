package yueshenginfo.com.mynovel.module.review.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import yueshenginfo.com.mynovel.module.review.adapter.ReviewAdapter;
import yueshenginfo.com.mynovel.module.review.dto.ReviewDto;
import yueshenginfo.com.mynovel.module.review.presenter.MoreReviewPresenter;
import yueshenginfo.com.mynovel.module.review.view.MoreReviewView;
import yueshenginfo.com.mynovel.publics.utils.T;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class ReviewFragment extends IBaseFragment implements MoreReviewView {
    private RecyclerView rv_review;
    private SpringView mSpringView;
    private ReviewAdapter mReviewAdapter;
    private ArrayList<ReviewDto.ReviewsVO> mReviewDtosList;
    private MoreReviewPresenter mMoreReviewPresenter;
    private String bookId;
    private int startFlag;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_review, container, false);
        rv_review = (RecyclerView) view.findViewById(R.id.rv_review);
        mSpringView = (SpringView) view.findViewById(R.id.springview);
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
        bookId ="";
        mReviewDtosList = new ArrayList<>();
        startFlag = 0;
        Log.e("'ddd",getArguments().getString("bookId"));
        bookId = getArguments().getString("bookId");
        mMoreReviewPresenter = new MoreReviewPresenter(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        rv_review.setLayoutManager(new LinearLayoutManager(mContext));
        mReviewAdapter = new ReviewAdapter(mContext, mReviewDtosList);
        rv_review.setAdapter(mReviewAdapter);
        rv_review.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                T.showShort(mContext, mReviewDtosList.get(i).getTitle());
            }
        });
        initRefushLoadmore();
    }

    @Override
    public void initDatas() {
        getMoreReview();
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
                        getMoreReview();
                    }
                }, 1000);
                mSpringView.onFinishFreshAndLoad();
            }
        });
        mSpringView.setFooter(new DefaultFooter(mContext));
    }

    /**
     * 请求数据
     */
    private void getMoreReview() {
        showProgress();
        Map<String, Object> params = new HashMap<>();
        params.put("book", bookId);
        params.put("sort", "updated");
        params.put("start", startFlag);
        params.put("limit", 20);
        mMoreReviewPresenter.getMoreReview(params);
    }

    @Override
    public void getMoreReviewResult(boolean isOk, ReviewDto dto) {
        if (isOk) {
            mReviewDtosList.addAll(dto.getReviews());
        }
        mReviewAdapter.notifyDataSetChanged();
        dismissProgress();
    }

}
