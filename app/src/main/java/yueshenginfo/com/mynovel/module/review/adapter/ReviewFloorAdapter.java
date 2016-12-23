package yueshenginfo.com.mynovel.module.review.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.review.dto.ReviewFloorDto;
import yueshenginfo.com.mynovel.publics.common.Constants;
import yueshenginfo.com.mynovel.publics.utils.DateUtil;
import yueshenginfo.com.mynovel.publics.utils.Utils;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class ReviewFloorAdapter extends BaseQuickAdapter<ReviewFloorDto.CommentsVO> {
    public ReviewFloorAdapter(Context context, List<ReviewFloorDto.CommentsVO> data) {
        super(R.layout.review_floor_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ReviewFloorDto.CommentsVO dto) {
        baseViewHolder.setText(R.id.user_name, dto.getAuthor().getNickname());
        baseViewHolder.setText(R.id.review_content, dto.getContent());
        baseViewHolder.setText(R.id.floor_num, String.format(mContext.getString(R.string.review_floor_num), dto.getFloor()));
        baseViewHolder.setText(R.id.user_levle, String.format(mContext.getString(R.string.book_detail_user_lv), dto.getAuthor().getLv()));
        SimpleDraweeView mSimpleDraweeView = baseViewHolder.getView(R.id.user_head);
        mSimpleDraweeView.setImageURI(Utils.getImgUrl(Constants.ServiceInterFace.IMG_BASE_URL + dto.getAuthor().getAvatar()));
        String str = DateUtil.converTime(DateUtil.str2Calendar(DateUtil.Standardtime(dto.getCreated()), "").getTimeInMillis());
        baseViewHolder.setText(R.id.tv_review_time, str);
        baseViewHolder.setText(R.id.tv_like_num,String.valueOf(dto.getLikeCount()));
    }
}
