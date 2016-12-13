package yueshenginfo.com.mynovel.module.morenovel.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.morenovel.adapter.MoreNovelAdapter;
import yueshenginfo.com.mynovel.module.morenovel.dto.BooksDto;
import yueshenginfo.com.mynovel.module.morenovel.presenter.BooksPresenter;
import yueshenginfo.com.mynovel.module.morenovel.view.BooksView;

/**
 * Created by huchao on 2016/12/9.
 * Email 1064224874@qq.com
 */
public class NewBooksFragment extends IBaseFragment implements BooksView {
    private RecyclerView mRecyclerView;
    private MoreNovelAdapter mMoreNovelAdapter;
    private ArrayList<BooksDto.BooksVO> mBooksVOArrayList;
    private BooksPresenter mBooksPresenter;
    private String type;
    private String category;

    public NewBooksFragment(String type,String category) {
        this.type = type;
        this.category = category;
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.more_novel_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        mBooksVOArrayList = new ArrayList<>();
        mBooksPresenter = new BooksPresenter(this);
        mRecyclerView = getViewById(R.id.more_novel_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mMoreNovelAdapter = new MoreNovelAdapter(mContext, mBooksVOArrayList);
        mRecyclerView.setAdapter(mMoreNovelAdapter);

    }

    @Override
    public void initDatas() {
        getBooksMore();
    }

    private void getBooksMore() {
        Map<String, Object> params = new HashMap<>();
        params.put("gender", "male");
        params.put("type", type);
        params.put("major", category);
        mBooksPresenter.getBooks(params);
    }

    @Override
    public void getBooksResult(boolean isOk, BooksDto booksDto) {
        if (isOk) {
            mBooksVOArrayList.addAll(booksDto.getBooks());
//            for (int i=0;i<booksVO.get_id().length();i++){
//                Log.e("booksVO", mBooksVOArrayList.get(i).getTitle());
//            }

        }
        mMoreNovelAdapter.notifyDataSetChanged();
    }

}
