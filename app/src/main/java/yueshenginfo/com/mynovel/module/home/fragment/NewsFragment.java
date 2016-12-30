package yueshenginfo.com.mynovel.module.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.news.activity.NewsActivty;

/**
 * Created by huchao on 2016/11/30.
 * Email 1064224874@qq.com
 */
public class NewsFragment extends IBaseFragment {

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, NewsActivty.class));
            }
        });
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {


    }


    @Override
    public void initDatas() {

    }

}
