package yueshenginfo.com.mynovel.module.morenovel.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import yueshenginfo.com.mynovel.IBaseActivity;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.dto.CategoryEvent;
import yueshenginfo.com.mynovel.module.morenovel.dto.BooksDto;
import yueshenginfo.com.mynovel.module.morenovel.fragment.HotBooksFragment;
import yueshenginfo.com.mynovel.module.morenovel.fragment.NewBooksFragment;
import yueshenginfo.com.mynovel.module.morenovel.fragment.OverFragment;
import yueshenginfo.com.mynovel.module.morenovel.fragment.ReputionFragment;
import yueshenginfo.com.mynovel.module.morenovel.presenter.BooksPresenter;
import yueshenginfo.com.mynovel.module.morenovel.view.BooksView;
import yueshenginfo.com.mynovel.publics.utils.ViewFindUtils;

public class MoreNovelactivity extends IBaseActivity implements BooksView {


    private String[] title = {"新书", "热门", "口碑", "完结"};
    private ArrayList<Fragment> mFragmentArrayList;
    private View mDecorView;
    private SegmentTabLayout mSegmentTabLayout;
    public String category;
    private BooksPresenter mBooksPresenter;
    private String type;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_novelactivity);
        ButterKnife.bind(this);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        type = "new";
        // SegmentTabLayout相关初始化以及数据绑定
        mFragmentArrayList = new ArrayList<>();
        mDecorView = getWindow().getDecorView();
        category = getIntent().getStringExtra("category");
        mFragmentArrayList.add(new NewBooksFragment());
        mFragmentArrayList.add(new HotBooksFragment());
        mFragmentArrayList.add(new ReputionFragment());
        mFragmentArrayList.add(new OverFragment());
        mSegmentTabLayout = ViewFindUtils.find(mDecorView, R.id.more_novel_tablayout);
        mSegmentTabLayout.setTabData(title, this, R.id.fl_change, mFragmentArrayList);
        mSegmentTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (position == 0) {
                    type = "new";
                    Log.e("nicai", "new");
                } else if (position == 1) {
                    type = "hot";
                    Log.e("nicai", "hot");
                } else if (position == 2) {
                    type = "reputation";
                    Log.e("nicai", "reputation");
                } else if (position == 3) {
                    type = "over";
                    Log.e("nicai", "over");
                }
                getBooksMore();
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
        mSegmentTabLayout.setCurrentTab(0);
        mBooksPresenter = new BooksPresenter(this);
        getBooksMore();
    }


    @Override
    public void initDatas() {

    }

    private void getBooksMore() {
        Map<String, Object> params = new HashMap<>();
        params.put("gender", "male");//gender代表男性还是女性
        params.put("type", type);//type代表热门。完结等
        params.put("major", category);//major代表玄幻等种类
        params.put("limit", 5);//limit代表pagesize
        params.put("start", 0);//start代表从那个item开始
        Log.e("nicai", params.toString());
        mBooksPresenter.getBooks(params);
    }

    @Override
    public void getBooksResult(boolean isOk, BooksDto booksVO) {
        if (isOk) {
            EventBus.getDefault().post(new CategoryEvent(booksVO.getBooks()));
        }
    }
}
