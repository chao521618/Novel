package yueshenginfo.com.mynovel.module.search.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import yueshenginfo.com.mynovel.IBaseActivity;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.bookdetail.activity.BookDetailActivity;
import yueshenginfo.com.mynovel.module.search.adapter.SearchResultAdapter;
import yueshenginfo.com.mynovel.module.search.dto.SeachBooksDto;
import yueshenginfo.com.mynovel.module.search.presenter.SearchResultPresenter;
import yueshenginfo.com.mynovel.module.search.view.SearchResultView;

public class SearchResultActivty extends IBaseActivity implements SearchResultView {

    @Bind(R.id.rv)
    RecyclerView rv;
    private SearchResultAdapter mSearchResultAdapter;
    private String query;
    private SearchResultPresenter mSearchResultPresenter;
    private ArrayList<SeachBooksDto.BooksVO> mBooksVOsLists;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result_activty);
        ButterKnife.bind(this);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        mBooksVOsLists=new ArrayList<>();
        mSearchResultPresenter = new SearchResultPresenter(this);
        query = getIntent().getStringExtra("query");
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        mSearchResultAdapter = new SearchResultAdapter(mContext, mBooksVOsLists);
        rv.setAdapter(mSearchResultAdapter);
        rv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Intent mIntent=new Intent(mContext, BookDetailActivity.class);
                mIntent.putExtra("id",mBooksVOsLists.get(i).get_id());
                startActivity(mIntent);
                //T.showShort(mContext,mBooksVOsLists.get(i).getTitle());
            }

        });
    }

    @Override
    public void initDatas() {
        getSearch();
    }

    private void getSearch() {
        Map<String, Object> params = new HashMap<>();
        params.put("query", query);
        mSearchResultPresenter.getSearch(params);
    }

    @Override
    public void getSearchResult(boolean isOk, SeachBooksDto dto) {
        if (isOk) {
            mBooksVOsLists.addAll(dto.getBooks());
        }
        mSearchResultAdapter.notifyDataSetChanged();
    }
}
