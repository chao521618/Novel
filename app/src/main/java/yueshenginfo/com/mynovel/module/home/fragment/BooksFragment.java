package yueshenginfo.com.mynovel.module.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;

import java.util.ArrayList;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.adapter.BooksAdapter;
import yueshenginfo.com.mynovel.module.home.dto.BooksCategoryDto;
import yueshenginfo.com.mynovel.module.home.presenter.BooksCategoryPresenter;
import yueshenginfo.com.mynovel.module.home.view.BooksCategoryView;
import yueshenginfo.com.mynovel.module.morenovel.activity.MoreNovelactivity;

/**
 * Created by huchao on 2016/11/30.
 * Email 1064224874@qq.com
 */
public class BooksFragment extends IBaseFragment implements BooksCategoryView {
    private RecyclerView mRecyclerView;
    private BooksAdapter mBooksAdapter;
    private ArrayList<BooksCategoryDto.MaleVO> mMaleVOArrayList;
    private BooksCategoryPresenter mBooksCategoryPresenter;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.books_fragment_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = getViewById(R.id.books_rv);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        mMaleVOArrayList = new ArrayList<>();
        mBooksCategoryPresenter = new BooksCategoryPresenter(this);
        //RecyclerView的布局管理器以及绑定adapter
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mBooksAdapter = new BooksAdapter(mContext, mMaleVOArrayList);
        mRecyclerView.setAdapter(mBooksAdapter);
        initRecyclerOnclickListener();
    }

    @Override
    public void initDatas() {
        //获取书籍类别
        mBooksCategoryPresenter.getBooksCategory("statistics");
    }

    @Override
    public void getBooksCategoryResult(boolean isOk, BooksCategoryDto dto) {
        if (isOk) {
            mMaleVOArrayList.addAll(dto.getMale());
        }
        mBooksAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    private void initRecyclerOnclickListener() {
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void SimpleOnItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

                Intent intent = new Intent(mContext, MoreNovelactivity.class);
                intent.putExtra("category", mMaleVOArrayList.get(i).getName());
                Log.e("category===>", mMaleVOArrayList.get(i).getName());
                startActivity(intent);
            }
        });
    }
}
