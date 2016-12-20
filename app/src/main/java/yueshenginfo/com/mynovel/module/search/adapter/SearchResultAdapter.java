package yueshenginfo.com.mynovel.module.search.adapter;

import android.content.Context;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.search.dto.SeachBooksDto;
import yueshenginfo.com.mynovel.publics.common.Constants;
import yueshenginfo.com.mynovel.publics.utils.Utils;

/**
 * Created by huchao on 2016/12/19.
 * Email 1064224874@qq.com
 */
public class SearchResultAdapter extends BaseQuickAdapter<SeachBooksDto.BooksVO> {

    public SearchResultAdapter(Context context, List<SeachBooksDto.BooksVO> data) {
        super(R.layout.search_result_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, SeachBooksDto.BooksVO seachBooksDto) {
        int width= Utils.getScreenWidth(mContext)/5;
        SimpleDraweeView mSimpleDraweeView=baseViewHolder.getView(R.id.sv_search_result_item);
        mSimpleDraweeView.setLayoutParams(new LinearLayout.LayoutParams(width*13/12,width*4/3));
        mSimpleDraweeView.setImageURI(Utils.getImgUrl(Constants.ServiceInterFace.IMG_BASE_URL+seachBooksDto.getCover()));
        baseViewHolder.setText(R.id.book_name,seachBooksDto.getTitle());
        baseViewHolder.setText(R.id.book_author,seachBooksDto.getAuthor());
        baseViewHolder.setText(R.id.book_person,String.valueOf(seachBooksDto.getLatelyFollower()));
        baseViewHolder.setText(R.id.book_category,seachBooksDto.getCat());
    }
}
