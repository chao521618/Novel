package yueshenginfo.com.mynovel.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;

/**
 * Created by huchao on 2016/11/30.
 * Email 1064224874@qq.com
 */
public class SearchFragment extends IBaseFragment{
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View  view=inflater.inflate(R.layout.fragment_search,container,false);
        return null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initDatas() {

    }
}
