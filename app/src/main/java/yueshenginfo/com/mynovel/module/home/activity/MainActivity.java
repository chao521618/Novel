package yueshenginfo.com.mynovel.module.home.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import yueshenginfo.com.mynovel.IBaseActivity;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.dto.TabEntity;
import yueshenginfo.com.mynovel.module.home.fragment.BookShelfFragment;
import yueshenginfo.com.mynovel.module.home.fragment.BooksFragment;

public class MainActivity extends IBaseActivity {
    @Bind(R.id.fl_change)
    FrameLayout flChange;
    @Bind(R.id.tablayout)
    CommonTabLayout tablayout;
    private String[] mTitles = {"书架", "书城", "搜索", "原创", "我的"};
    private int[] mIconUnselectIds = {
            R.drawable.icon_unselect_mybook,
            R.drawable.icon_unselect_books,
            R.drawable.icon_unselect_search,
            R.drawable.icon_unselect_original,
            R.drawable.icon_unselect_my};
    private int[] mIconSelectIds = {
            R.drawable.icon_select_mybook,
            R.drawable.icon_select_books,
            R.drawable.icon_select_search,
            R.drawable.icon_select_original,
            R.drawable.icon_select_my};
    private ArrayList<CustomTabEntity> mArrayList;
    private ArrayList<Fragment> fragmentList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        mArrayList = new ArrayList<>();
        fragmentList = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            mArrayList.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        fragmentList.add(new BookShelfFragment());
        fragmentList.add(new BooksFragment());
        fragmentList.add(new BookShelfFragment());
        fragmentList.add(new BookShelfFragment());
        fragmentList.add(new BookShelfFragment());
        tablayout.setTabData(mArrayList, this, R.id.fl_change, fragmentList);
    }

    @Override
    public void initDatas() {
    }

    private void initAdapter() {

    }

}
