package yueshenginfo.com.mynovel.module.home.adapter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.dto.BookRecommendDto;
import yueshenginfo.com.mynovel.publics.common.Constants;
import yueshenginfo.com.mynovel.publics.utils.Utils;

/**
 * Created by huchao on 2016/12/1.
 * Email 1064224874@qq.com
 */
public class BookShelfAdapter extends BaseQuickAdapter<BookRecommendDto.BooksVO> {

    public BookShelfAdapter(Context context, List<BookRecommendDto.BooksVO> data) {
        super(R.layout.bookshelf_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, BookRecommendDto.BooksVO bookShelfBean) {
        int width = Utils.getScreenWidth(mContext) / 3;
        baseViewHolder.setText(R.id.book_name, bookShelfBean.getTitle());
        if (bookShelfBean.isHasCp()==true) {
            baseViewHolder.setText(R.id.book_state, "完结");
        }else {
            baseViewHolder.setText(R.id.book_state, "未完结");
        }
        Log.e("bookShelfBean.getLatelyFollower()", String.valueOf(bookShelfBean.getLatelyFollower()));
        baseViewHolder.setText(R.id.book_readstate,String.valueOf(bookShelfBean.getLatelyFollower()));
        //item的一个布局
        LinearLayout mLinearLayout = baseViewHolder.getView(R.id.bookshelf_item_layout);
        //图片
        SimpleDraweeView mSimpleDraweeView = baseViewHolder.getView(R.id.bookshelf_item_view);
        //图片底下的一个布局
        LinearLayout mBookIntroductionLayout = baseViewHolder.getView(R.id.book_inroduction);
        mLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(width, width * 3 / 2));
        mSimpleDraweeView.setLayoutParams(new LinearLayout.LayoutParams(width * 4 / 5, width * 30 / 29));
        mBookIntroductionLayout.setLayoutParams(new LinearLayout.LayoutParams(width * 4 / 5, ViewGroup.LayoutParams.WRAP_CONTENT));
        mSimpleDraweeView.setImageURI(Utils.getImgUrl(Constants.ServiceInterFace.IMG_BASE_URL + bookShelfBean.getCover()));
    }
}
