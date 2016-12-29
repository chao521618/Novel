package yueshenginfo.com.mynovel.module.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by huchao on 2016/12/28.
 * Email 1064224874@qq.com
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragmentList;
    private String[] title;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> mFragmentList, String[] title) {
        super(fm);
        this.mFragmentList = mFragmentList;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];

    }
}
