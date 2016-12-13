package yueshenginfo.com.mynovel.module.morenovel.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.morenovel.dto.BooksDto;
import yueshenginfo.com.mynovel.publics.common.Constants;
import yueshenginfo.com.mynovel.publics.utils.Utils;

/**
 * Created by huchao on 2016/12/9.
 * Email 1064224874@qq.com
 */
public class MoreNovelAdapter extends BaseQuickAdapter<BooksDto.BooksVO> {

    public MoreNovelAdapter(Context context, List<BooksDto.BooksVO> data) {
        super(R.layout.books_more_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, BooksDto.BooksVO booksDto) {
        SimpleDraweeView mSimpleDraweeView = baseViewHolder.getView(R.id.book_face_sdview);
        mSimpleDraweeView.setImageURI(Utils.getImgUrl(Constants.ServiceInterFace.IMG_BASE_URL+booksDto.getCover()));
        baseViewHolder.setText(R.id.book_name_tv, booksDto.getTitle());
        baseViewHolder.setText(R.id.book_author, booksDto.getAuthor());
        baseViewHolder.setText(R.id.book_desc, booksDto.getShortIntro());
    }
}
