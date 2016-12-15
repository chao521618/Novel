package yueshenginfo.com.mynovel.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.dto.AllLookBooksDto;
import yueshenginfo.com.mynovel.module.home.presenter.AllLookBooksPresenter;
import yueshenginfo.com.mynovel.module.home.view.AllLookBooksView;
import yueshenginfo.com.mynovel.publics.utils.T;

/**
 * Created by huchao on 2016/11/30.
 * Email 1064224874@qq.com
 */
public class SearchFragment extends IBaseFragment implements AllLookBooksView, View.OnClickListener {
    //流式布局
    private TagFlowLayout mTagFlowLayout;
    private ArrayList<String> mArrayList;
    private AllLookBooksPresenter mAllLookBooksPresenter;
    private LinearLayout mLinearLayout;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTagFlowLayout = getViewById(R.id.flowlayout);
        mLinearLayout=getViewById(R.id.layout_refresh);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        mArrayList = new ArrayList<>();
        mAllLookBooksPresenter = new AllLookBooksPresenter(this);
        initFlowLayout();
        mLinearLayout.setOnClickListener(this);
    }

    @Override
    public void initDatas() {
        getAllLookBooks();
    }

    /**
     * 流式布局的方法使用
     */
    private void initFlowLayout() {
        mTagFlowLayout.setAdapter(new TagAdapter<String>(mArrayList) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView mTextView = (TextView) LayoutInflater.from(mContext).inflate(R.layout.tv_words, parent, false);
                mTextView.setText(s);
                return mTextView;
            }
        });
        mTagFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                T.showShort(mContext,position);
                return false;
            }
        });
    }

    private void getAllLookBooks() {
        Map<String, Object> params = new HashMap<>();
        mAllLookBooksPresenter.getAllLookBooks(params);
    }

    @Override
    public void getAllLookBooksResult(boolean isOk, AllLookBooksDto dto) {
        if (isOk) {
            Random mRandom = new Random();
            mArrayList.clear();
            for (int i=0;i<8;i++){
                if ( !mArrayList.contains(dto.getHotWords().get(mRandom.nextInt(dto.getHotWords().size())))) {
                    mArrayList.add(dto.getHotWords().get(mRandom.nextInt(dto.getHotWords().size())));
                }
            }
            initFlowLayout();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_refresh:
                getAllLookBooks();
            break;

        }
    }
}
