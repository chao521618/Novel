package yueshenginfo.com.mynovel.module.news.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import yueshenginfo.com.mynovel.IBaseActivity;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.news.adapter.TextAdapter;

public class NewsDetailActivity extends IBaseActivity {

    @Bind(R.id.rv)
    RecyclerView rv;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @Bind(R.id.sv)
    SimpleDraweeView sv;
    private ArrayList<String> arrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            arrayList.add(String.valueOf(i));
        }
        toolbarLayout.setTitle("Name");
        //通过CollapsingToolbarLayout修改字体颜色
        toolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.reader_theme_color));//设置还没收缩时状态下字体颜色
        toolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.page_white_bg));//设置收缩后Toolbar上字体的颜色

        sv.setImageURI("http://dingyue.nosdn.127.net/tpiqK1GtvQI0tPZgSMNmShV8yo=6hT9clAH4OwnCmQ2Mb1482798195848compressflag.jpg");

        rv.setLayoutManager(new LinearLayoutManager(mContext));
        TextAdapter mTextAdapter = new TextAdapter(mContext, arrayList);
        rv.setAdapter(mTextAdapter);
    }

    @Override
    public void initDatas() {

    }
}
