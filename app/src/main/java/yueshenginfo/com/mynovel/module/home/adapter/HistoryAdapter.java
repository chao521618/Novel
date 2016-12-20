package yueshenginfo.com.mynovel.module.home.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yueshenginfo.com.mynovel.R;

/**
 * Created by huchao on 2016/12/19.
 * Email 1064224874@qq.com
 */
public class HistoryAdapter extends BaseQuickAdapter<String> {

    public HistoryAdapter(Context context, List<String> data) {
        super(R.layout.books_history_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String mString) {
        baseViewHolder.setText(R.id.book_name, mString);
    }
}
