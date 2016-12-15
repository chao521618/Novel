package yueshenginfo.com.mynovel.module.home.adapter;

import android.content.Context;
import android.net.Uri;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.dto.BooksBean;
import yueshenginfo.com.mynovel.publics.utils.Utils;

/**
 * Created by huchao on 2016/12/14.
 * Email 1064224874@qq.com
 */
public class CategoryItemAdapter extends BaseQuickAdapter<BooksBean> {
    public CategoryItemAdapter(Context context, List<BooksBean> data) {
        super(R.layout.category_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, BooksBean booksVO) {
        int width= Utils.getScreenWidth(mContext)/3;
        SimpleDraweeView mSimpleDraweeView = baseViewHolder.getView(R.id.springview);
        mSimpleDraweeView.setLayoutParams(new LinearLayout.LayoutParams(width*6/10,width*4/5));
        mSimpleDraweeView.setImageURI(Uri.parse(booksVO.getImg()));
        baseViewHolder.setText(R.id.book_name, booksVO.getName());
    }
}
