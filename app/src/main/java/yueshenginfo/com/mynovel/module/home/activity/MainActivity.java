package yueshenginfo.com.mynovel.module.home.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

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
import yueshenginfo.com.mynovel.module.home.fragment.NewsFragment;
import yueshenginfo.com.mynovel.module.home.fragment.OriginalFragment;
import yueshenginfo.com.mynovel.module.home.fragment.SearchFragment;

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
    private long exitTime = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initStatusBar();
        initViews();
        initDatas();
    }

    private void initStatusBar() {
        //21代表android 5.0
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(getResources().getColor(R.color.reader_theme_color));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.reader_theme_color));
            /**
             * 获取状态栏高度——方法1
             * */
            int statusBarHeight1 = -1;
//获取status_bar_height资源的ID
            int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                //根据资源ID获取响应的尺寸值
                statusBarHeight1 = getResources().getDimensionPixelSize(resourceId);
            }
            Log.e("WangJ", "状态栏-方法1:" + statusBarHeight1);
        }
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
        fragmentList.add(new SearchFragment());
        fragmentList.add(new OriginalFragment());
        fragmentList.add(new NewsFragment());
        tablayout.setTabData(mArrayList, this, R.id.fl_change, fragmentList);
    }

    @Override
    public void initDatas() {

    }

    /**
     * 连续点击退出程序
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //两秒之内按返回键就会退出
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序哦", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
