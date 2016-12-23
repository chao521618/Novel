package yueshenginfo.com.mynovel.module.review.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.review.adapter.ReviewAdapter;
import yueshenginfo.com.mynovel.module.review.dto.ReviewDto;
import yueshenginfo.com.mynovel.module.review.presenter.MoreReviewPresenter;
import yueshenginfo.com.mynovel.module.review.view.MoreReviewView;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class ReviewFragment extends IBaseFragment implements MoreReviewView {
    private RecyclerView rv_review;
    private ReviewAdapter mReviewAdapter;
    private ArrayList<ReviewDto.ReviewsVO> mReviewDtosList;
    private MoreReviewPresenter mMoreReviewPresenter;
    private String bookId;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_review, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rv_review = getViewById(R.id.rv_review);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        mReviewDtosList = new ArrayList<>();
        Log.e("bookId",getArguments().getString("bookId"));
        bookId=getArguments().getString("bookId");
        mMoreReviewPresenter = new MoreReviewPresenter(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        rv_review.setLayoutManager(new LinearLayoutManager(mContext));
        mReviewAdapter = new ReviewAdapter(mContext, mReviewDtosList);
        rv_review.setAdapter(mReviewAdapter);
    }

    @Override
    public void initDatas() {
        getMoreReview();
    }

    /**
     * 请求数据
     */
    private void getMoreReview() {
        Map<String, Object> params = new HashMap<>();
        params.put("book", bookId);
        params.put("sort", "updated");
        params.put("start", 0);
        params.put("limit", 20);
        mMoreReviewPresenter.getMoreReview(params);
    }

    @Override
    public void getMoreReviewResult(boolean isOk, ReviewDto dto) {
        if (isOk) {
            mReviewDtosList.addAll(dto.getReviews());
        }
        mReviewAdapter.notifyDataSetChanged();
    }
}
