package yueshenginfo.com.mynovel.module.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.adapter.HistoryAdapter;
import yueshenginfo.com.mynovel.module.home.adapter.ListPopAdapter;
import yueshenginfo.com.mynovel.module.home.dto.AllLookBooksDto;
import yueshenginfo.com.mynovel.module.home.dto.KeyWordsDto;
import yueshenginfo.com.mynovel.module.home.presenter.AllLookBooksPresenter;
import yueshenginfo.com.mynovel.module.home.presenter.SearchWordsPresenter;
import yueshenginfo.com.mynovel.module.home.view.AllLookBooksView;
import yueshenginfo.com.mynovel.module.home.view.SearchWordsView;
import yueshenginfo.com.mynovel.module.search.activity.SearchResultActivty;
import yueshenginfo.com.mynovel.publics.common.MessageInfo;
import yueshenginfo.com.mynovel.publics.utils.EmptyUtils;
import yueshenginfo.com.mynovel.publics.utils.T;

/**
 * Created by huchao on 2016/11/30.
 * Email 1064224874@qq.com
 */
public class SearchFragment extends IBaseFragment implements AllLookBooksView, View.OnClickListener, SearchWordsView {
    //流式布局
    private TagFlowLayout mTagFlowLayout;
    private ArrayList<String> mArrayList;
    private AllLookBooksPresenter mAllLookBooksPresenter;
    private SearchWordsPresenter mSearchWordsPresenter;
    private LinearLayout mLinearLayout, search_layout;
    private ListPopupWindow mListPopupWindow;
    private ArrayList<String> mPopArrayList;
    private EditText mEditText;
    private ListPopAdapter mListPopAdapter;
    private ImageView iv_delete;
    private TextView tv_seach;
    private RecyclerView rv_histroy;
    private List<String> mList;
    private HistoryAdapter mHistoryAdapter;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTagFlowLayout = getViewById(R.id.flowlayout);
        mLinearLayout = getViewById(R.id.layout_refresh);
        search_layout = getViewById(R.id.search_layout);
        mEditText = getViewById(R.id.et_seach);
        iv_delete = getViewById(R.id.iv_delete);
        tv_seach = getViewById(R.id.tv_seach);
        rv_histroy = getViewById(R.id.rv_histroy);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        mArrayList = new ArrayList<>();
        mPopArrayList = new ArrayList<>();
        mList = new ArrayList<>();
        mAllLookBooksPresenter = new AllLookBooksPresenter(this);
        mSearchWordsPresenter = new SearchWordsPresenter(this);
        initFlowLayout();
        //点击事件
        mLinearLayout.setOnClickListener(this);
        iv_delete.setOnClickListener(this);
        tv_seach.setOnClickListener(this);

        initListPopupWindow();
//        for (int i=0;i<10;i++){
//            mPopArrayList.add(String.valueOf(i));
//        }

        //键盘中的搜索键的监听
//        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//
//                }
//                return false;
//            }
//        });
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (EmptyUtils.isNotEmpty(mEditText.getText().toString())) {

                    getSearchWord();
                    mListPopupWindow.show();
                    iv_delete.setVisibility(View.VISIBLE);
                }
            }
        });
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
               // T.showShort(mContext, mArrayList.get(position));
                Intent mIntent=new Intent(mContext, SearchResultActivty.class);
                mIntent.putExtra("query",mArrayList.get(position));
                startActivity(mIntent);
                return true;
            }
        });
    }

    /**
     * 获取大家都在看的书
     */
    private void getAllLookBooks() {
        Map<String, Object> params = new HashMap<>();
        mAllLookBooksPresenter.getAllLookBooks(params);
    }

    @Override
    public void getAllLookBooksResult(boolean isOk, AllLookBooksDto dto) {
        if (isOk) {
            Random mRandom = new Random();
            mArrayList.clear();
            for (int i = 0; i < 8; i++) {
                // if (!mArrayList.contains(dto.getHotWords().get(mRandom.nextInt(dto.getHotWords().size())))) {
                mArrayList.add(dto.getHotWords().get(mRandom.nextInt(dto.getHotWords().size())));
                //}
            }
            initFlowLayout();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_refresh:
                getAllLookBooks();
                break;
            case R.id.iv_delete:
                mEditText.setText("");
                break;
            case R.id.tv_seach:
                if (EmptyUtils.isNotEmpty(mEditText.getText().toString())) {
                    Intent mIntent = new Intent(mContext, SearchResultActivty.class);
                    mIntent.putExtra("query", mEditText.getText().toString());
                    startActivity(mIntent);
                } else {
                    T.showShort(mContext, "请输入搜索内容");
                }
                mList.add(mEditText.getText().toString());
                if (mList.size()-1==0){

                }
                MessageInfo.setHistorySearch(mContext, mEditText.getText().toString());

                break;

        }
    }

    /**
     * 搜索下拉 利用ListPopupWindow
     */
    private void initListPopupWindow() {
        mListPopupWindow = new ListPopupWindow(mContext);
        mListPopupWindow.setAnchorView(search_layout);
        mListPopupWindow.setModal(true);
        mListPopupWindow.setWidth(ListPopupWindow.WRAP_CONTENT);
        mListPopupWindow.setHeight(ListPopupWindow.WRAP_CONTENT);
        mListPopupWindow.setInputMethodMode(mListPopupWindow.INPUT_METHOD_NEEDED);
        mListPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        mListPopAdapter = new ListPopAdapter(mContext, mPopArrayList);
        mListPopupWindow.setAdapter(mListPopAdapter);
        mListPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(mContext, mPopArrayList.get(position), Toast.LENGTH_SHORT).show();
                mEditText.setText(mPopArrayList.get(position));
                mListPopupWindow.dismiss();
            }
        });
    }

    private void initRecyclerView() {
        rv_histroy.setLayoutManager(new LinearLayoutManager(mContext));
        mHistoryAdapter = new HistoryAdapter(mContext, mList);
        rv_histroy.setAdapter(mHistoryAdapter);
    }


    /**
     * 获取搜索关键词
     */
    private void getSearchWord() {
        Map<String, Object> params = new HashMap<>();
        params.put("query", mEditText.getText().toString());
        mSearchWordsPresenter.getSearchWords(params);
    }

    @Override
    public void getSearchWordsResult(boolean isOk, KeyWordsDto dto) {
        if (isOk) {
            mPopArrayList.clear();
            for (int i = 0; i < dto.getKeywords().size(); i++) {
                mPopArrayList.add(dto.getKeywords().get(i));
            }
            mListPopAdapter.notifyDataSetChanged();
        }
    }

}
