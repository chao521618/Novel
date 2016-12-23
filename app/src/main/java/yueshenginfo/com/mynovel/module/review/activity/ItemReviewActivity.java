package yueshenginfo.com.mynovel.module.review.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import yueshenginfo.com.mynovel.IBaseActivity;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.review.adapter.ReviewFloorAdapter;
import yueshenginfo.com.mynovel.module.review.adapter.UserLikeNumAdapter;
import yueshenginfo.com.mynovel.module.review.dto.ReviewFloorDto;
import yueshenginfo.com.mynovel.module.review.dto.UserReviewDto;
import yueshenginfo.com.mynovel.module.review.presenter.ReviewFloorPresetner;
import yueshenginfo.com.mynovel.module.review.presenter.UserReviewPresenter;
import yueshenginfo.com.mynovel.module.review.view.ReviewFloorView;
import yueshenginfo.com.mynovel.module.review.view.UserReviewView;
import yueshenginfo.com.mynovel.publics.common.Constants;
import yueshenginfo.com.mynovel.publics.utils.DateUtil;
import yueshenginfo.com.mynovel.publics.utils.Utils;

public class ItemReviewActivity extends IBaseActivity implements UserReviewView, ReviewFloorView {

    @Bind(R.id.sv_user_head)
    SimpleDraweeView svUserHead;
    @Bind(R.id.user_name)
    TextView userName;
    @Bind(R.id.item_review_time)
    TextView itemReviewTime;
    @Bind(R.id.review_title)
    TextView reviewTitle;
    @Bind(R.id.review_content)
    TextView reviewContent;
    @Bind(R.id.rv_like)
    RecyclerView rvLike;
    @Bind(R.id.tv_like_num)
    TextView tvLikeNum;
    @Bind(R.id.rv_review_floor)
    RecyclerView rvReviewFloor;
    //用户id
    private String id;
    private UserReviewPresenter mUserReviewPresenter;
    private UserLikeNumAdapter mUserLikeNumAdapter;
    private ArrayList<ReviewFloorDto.CommentsVO> mCommentsVOLists;
    private ArrayList<ReviewFloorDto.CommentsVO> mTotlesVOLists;
    private ReviewFloorPresetner mReviewFloorPresetner;
    private ReviewFloorAdapter mReviewFloorAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_review);
        ButterKnife.bind(this);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        id = getIntent().getStringExtra("id");
        mCommentsVOLists = new ArrayList<>();
        mTotlesVOLists = new ArrayList<>();
        mUserReviewPresenter = new UserReviewPresenter(this);
        mReviewFloorPresetner = new ReviewFloorPresetner(this);
        initRecyclerView();
    }

    @Override
    public void initDatas() {
        //请求用户详情评论
        mUserReviewPresenter.getUserReview(id);

        //请求楼层评论
        getReviewFloor();
    }

    private void initRecyclerView() {
        //用户点赞数量rv
        rvLike.setLayoutManager(new StaggeredGridLayoutManager(6, StaggeredGridLayoutManager.VERTICAL));
        mUserLikeNumAdapter = new UserLikeNumAdapter(mContext, mCommentsVOLists);
        rvLike.setAdapter(mUserLikeNumAdapter);
        //楼层评论rv
        rvReviewFloor.setLayoutManager(new LinearLayoutManager(mContext));
        mReviewFloorAdapter = new ReviewFloorAdapter(mContext, mTotlesVOLists);
        rvReviewFloor.setAdapter(mReviewFloorAdapter);

    }


    @Override
    public void getUserReviewViewResult(boolean isOk, UserReviewDto dto) {
        if (isOk) {
            svUserHead.setImageURI(Utils.getImgUrl(Constants.ServiceInterFace.IMG_BASE_URL + dto.getPost().getAuthor().getAvatar()));
            userName.setText(dto.getPost().getAuthor().getNickname());
            String str = DateUtil.converTime(DateUtil.str2Calendar(DateUtil.Standardtime(dto.getPost().getAuthor().getCreated()), "").getTimeInMillis());
            itemReviewTime.setText(str);
            reviewTitle.setText(dto.getPost().getTitle());
            reviewContent.setText(dto.getPost().getContent());
            tvLikeNum.setText(String.format(mContext.getString(R.string.book_review_like_num), dto.getPost().getLikeCount()));
        }
    }

    private void getReviewFloor() {
        Map<String, Object> params = new HashMap<>();
        params.put("idargs", id);
        params.put("start", 0);
        params.put("limit", 20);
        mReviewFloorPresetner.getReviewFloor(params);

    }

    @Override
    public void getReviewFloorResult(boolean isOk, ReviewFloorDto dto) {
        if (isOk) {
            for (int i = 0; i < 6; i++) {
                mCommentsVOLists.add(dto.getComments().get(i));
            }
            mTotlesVOLists.addAll(dto.getComments());
        }
        mUserLikeNumAdapter.notifyDataSetChanged();
        mReviewFloorAdapter.notifyDataSetChanged();
    }
}
