package yueshenginfo.com.mynovel.module.home.adapter;

import android.content.Context;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.dto.BookShelfBean;
import yueshenginfo.com.mynovel.publics.utils.Utils;

/**
 * Created by huchao on 2016/12/1.
 * Email 1064224874@qq.com
 */
public class BookShelfAdapter extends BaseQuickAdapter<BookShelfBean> {

    public BookShelfAdapter(Context context, List<BookShelfBean> data) {
        super(R.layout.bookshelf_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, BookShelfBean bookShelfBean) {
        int width = Utils.getScreenWidth(mContext) / 3;
        LinearLayout mLinearLayout = baseViewHolder.getView(R.id.bookshelf_item_layout);
        mLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(width,width*2));
    }
}
