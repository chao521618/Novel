package yueshenginfo.com.mynovel.module.home.adapter;

import android.content.Context;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.dto.BooksCategoryDto;
import yueshenginfo.com.mynovel.publics.utils.Utils;

/**
 * Created by huchao on 2016/12/7.
 * Email 1064224874@qq.com
 */
public class BooksAdapter extends BaseQuickAdapter<BooksCategoryDto.MaleVO> {
    public BooksAdapter(Context  context, List<BooksCategoryDto.MaleVO> data) {
        super(R.layout.books_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, BooksCategoryDto.MaleVO booksDto) {
        baseViewHolder.setText(R.id.book_category_name,booksDto.getName());
        LinearLayout mLinearLayout=baseViewHolder.getView(R.id.books_item_layout);
        int width= Utils.getScreenWidth(mContext);
        mLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(width,width*1/2));
        baseViewHolder.addOnClickListener(R.id.book_more);
    }
}
