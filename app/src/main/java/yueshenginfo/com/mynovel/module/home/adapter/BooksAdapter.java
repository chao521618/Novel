package yueshenginfo.com.mynovel.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.dto.BooksCategoryDto;
import yueshenginfo.com.mynovel.publics.common.DataProvider;

/**
 * Created by huchao on 2016/12/7.
 * Email 1064224874@qq.com
 */
public class BooksAdapter extends BaseQuickAdapter<BooksCategoryDto.MaleVO> {

    public BooksAdapter(Context context, List<BooksCategoryDto.MaleVO> data) {
        super(R.layout.books_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, BooksCategoryDto.MaleVO booksDto) {
        baseViewHolder.setText(R.id.book_category_name, booksDto.getName());
        RecyclerView mRecyclerView = baseViewHolder.getView(R.id.books_item_rv);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        CategoryItemAdapter mCategoryItemAdapter = new CategoryItemAdapter(mContext, DataProvider.books());
        mRecyclerView.setAdapter(mCategoryItemAdapter);
        baseViewHolder.addOnClickListener(R.id.book_more);

    }
//
//    private void initView() {
////        maBooksVOArrayList = new ArrayList<>();
////        mBooksPresenter = new BooksPresenter(this);
//    }

//    private void getBook() {
//        Map<String, Object> params = new HashMap<>();
//        params.put("gender", "male");//gender代表男性还是女性
//        params.put("type", "hot");//type代表热门。完结等
//        params.put("major", category);//major代表玄幻等种类
//        params.put("limit", 3);//limit代表pagesize
//        params.put("start", 0);//start代表从那个item开始
//        mBooksPresenter.getBooks(params);
//    }

//    @Override
//    public void getBooksResult(boolean isOk, BooksDto booksVO) {
//        if (isOk) {
//            maBooksVOArrayList.addAll(booksVO.getBooks());
//        }
//    }
//
//    @Override
//    public void showProgress() {
//
//    }
//
//    @Override
//    public void dismissProgress() {
//
//    }
}
