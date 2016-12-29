package yueshenginfo.com.mynovel.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.adapter.ViewPagerAdapter;
import yueshenginfo.com.mynovel.module.news.fragment.NewsListFragment;

/**
 * Created by huchao on 2016/11/30.
 * Email 1064224874@qq.com
 */
public class NewsFragment extends IBaseFragment {

    private ArrayList<Fragment> mFragmentList;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private String[] title = {"头条", "科技", "财经", "军事", "体育"};

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_picture, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTabLayout = getViewById(R.id.news_tabs);
        mViewPager = getViewById(R.id.news_viewpager);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new NewsListFragment());
        mFragmentList.add(new NewsListFragment());
        mFragmentList.add(new NewsListFragment());
        mFragmentList.add(new NewsListFragment());
        mFragmentList.add(new NewsListFragment());
        mViewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), mFragmentList, title);
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public void initDatas() {

    }


}
