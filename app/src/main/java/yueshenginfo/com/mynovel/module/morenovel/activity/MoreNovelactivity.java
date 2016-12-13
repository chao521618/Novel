package yueshenginfo.com.mynovel.module.morenovel.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.flyco.tablayout.SegmentTabLayout;

import java.util.ArrayList;

import butterknife.ButterKnife;
import yueshenginfo.com.mynovel.IBaseActivity;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.morenovel.fragment.NewBooksFragment;
import yueshenginfo.com.mynovel.publics.utils.ViewFindUtils;

public class MoreNovelactivity extends IBaseActivity {


    private String[] title = {"新书", "热门", "口碑", "完结"};
    private ArrayList<Fragment> mFragmentArrayList;
    private View mDecorView;
    private SegmentTabLayout mSegmentTabLayout;
    private String category;
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
        // SegmentTabLayout相关初始化以及数据绑定
        mFragmentArrayList = new ArrayList<>();
        mDecorView=getWindow().getDecorView();
        category=getIntent().getStringExtra("category");
        mFragmentArrayList.add(new NewBooksFragment("new",category));
        mFragmentArrayList.add(new NewBooksFragment("new",category));
        mFragmentArrayList.add(new NewBooksFragment("new",category));
        mFragmentArrayList.add(new NewBooksFragment("new",category));
        mSegmentTabLayout= ViewFindUtils.find(mDecorView, R.id.more_novel_tablayout);
        mSegmentTabLayout.setTabData(title,this,R.id.fl_change,mFragmentArrayList );

    }


    @Override
    public void initDatas() {

    }
}
