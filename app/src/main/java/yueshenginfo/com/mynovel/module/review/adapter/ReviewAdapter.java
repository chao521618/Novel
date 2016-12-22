package yueshenginfo.com.mynovel.module.review.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.review.dto.ReviewDto;
import yueshenginfo.com.mynovel.publics.common.Constants;
import yueshenginfo.com.mynovel.publics.utils.DateUtil;
import yueshenginfo.com.mynovel.publics.utils.Utils;

/**
 * Created by huchao on 2016/12/21.
 * Email 1064224874@qq.com
 */
public class ReviewAdapter extends BaseQuickAdapter<ReviewDto.ReviewsVO> {
    public ReviewAdapter(Context context, List<ReviewDto.ReviewsVO> data) {
        super(R.layout.review_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ReviewDto.ReviewsVO reviewDto) {
        SimpleDraweeView simpleDraweeView = baseViewHolder.getView(R.id.sv_user_head);
        simpleDraweeView.setImageURI(Utils.getImgUrl(Constants.ServiceInterFace.IMG_BASE_URL + reviewDto.getAuthor().getAvatar()));
        baseViewHolder.setText(R.id.user_name, reviewDto.getAuthor().getNickname());
        baseViewHolder.setText(R.id.user_levle,String.format(mContext.getString(R.string.book_detail_user_lv),reviewDto.getAuthor().getLv()));
        baseViewHolder.setText(R.id.user_review_content, reviewDto.getContent());
        baseViewHolder.setText(R.id.tv_like_num, String.valueOf(reviewDto.getLikeCount()));
        String str = DateUtil.Standardtime(reviewDto.getCreated());
        String time = DateUtil.converTime(DateUtil.str2Calendar(str, "").getTimeInMillis());
        baseViewHolder.setText(R.id.tv_review_time, time);

    }
}
