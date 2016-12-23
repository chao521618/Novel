package yueshenginfo.com.mynovel.module.review.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;

import com.flyco.tablayout.SegmentTabLayout;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import yueshenginfo.com.mynovel.IBaseActivity;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.fragment.BooksFragment;
import yueshenginfo.com.mynovel.module.review.fragment.ReviewFragment;

/**
 * Title: 评论和社区的activity<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 山东悦升<br/>
 * Company: 山东悦升信息技术有限公司<br/>
 * Author: created 胡超  <br/>
 * Since: 1.0
 * Version: 1.0
 */
public class ContainerActivity extends IBaseActivity {

    @Bind(R.id.fl_change)
    FrameLayout flChange;
    @Bind(R.id.container_tablayout)
    SegmentTabLayout mSegmentTabLayout;
    private String[] title = {"友评", "友圈"};
    private ArrayList<Fragment> mFragmentArrayList;
    private View mDecorView;
    //fragmentFlag 代表fragment标志位，1代表友评fragment 2代表友圈的fragment
    private int fragmentFlag;
    private String bookId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        ButterKnife.bind(this);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        ReviewFragment mReviewFragment=new ReviewFragment();
        setTitle(getIntent().getStringExtra("bookName"));
        fragmentFlag = getIntent().getIntExtra("fragmentFlag", 0);
        bookId = getIntent().getStringExtra("bookId");
        // SegmentTabLayout相关初始化以及数据绑定
        mFragmentArrayList = new ArrayList<>();
        mDecorView = getWindow().getDecorView();
        mFragmentArrayList.add(mReviewFragment);
        mFragmentArrayList.add(new BooksFragment());
        mSegmentTabLayout.setTabData(title, this, R.id.fl_change, mFragmentArrayList);
//        mSegmentTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelect(int position) {
//            }
//
//            @Override
//            public void onTabReselect(int position) {
//            }
//        });
        if (fragmentFlag == 1) {
            mSegmentTabLayout.setCurrentTab(0);
            Bundle mBundle = new Bundle();
            mBundle.putString("bookId", bookId);
            mReviewFragment.setArguments(mBundle);
        } else if (fragmentFlag == 2) {
            mSegmentTabLayout.setCurrentTab(1);
        }
    }

    @Override
    public void initDatas() {

    }
}
