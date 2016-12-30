package yueshenginfo.com.mynovel.module.news.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import yueshenginfo.com.mynovel.IBaseActivity;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.adapter.ViewPagerAdapter;
import yueshenginfo.com.mynovel.module.news.event.TypeEvent;
import yueshenginfo.com.mynovel.module.news.fragment.HeadsListFragment;

public class NewsActivty extends IBaseActivity {

    @Bind(R.id.news_tabs)
    TabLayout newsTabs;
    @Bind(R.id.news_viewpager)
    ViewPager newsViewpager;
    private ViewPagerAdapter mViewPagerAdapter;
    private String[] title = {"头条", "科技", "财经", "军事", "体育"};
    private ArrayList<Fragment> mFragmentList;


    private int flag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_activty);
        ButterKnife.bind(this);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new HeadsListFragment());
        mFragmentList.add(new HeadsListFragment());
        mFragmentList.add(new HeadsListFragment());
        mFragmentList.add(new HeadsListFragment());
        mFragmentList.add(new HeadsListFragment());
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragmentList, title);
        newsViewpager.setAdapter(mViewPagerAdapter);
        newsTabs.setupWithViewPager(newsViewpager);
        newsTabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                flag = tab.getPosition();
                EventBus.getDefault().post(new TypeEvent(flag));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    @Override
    public void initDatas() {

    }
//
}
