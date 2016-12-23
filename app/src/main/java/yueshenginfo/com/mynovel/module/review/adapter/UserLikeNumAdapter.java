package yueshenginfo.com.mynovel.module.review.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.review.dto.ReviewFloorDto;
import yueshenginfo.com.mynovel.publics.common.Constants;
import yueshenginfo.com.mynovel.publics.utils.Utils;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class UserLikeNumAdapter extends BaseQuickAdapter<ReviewFloorDto.CommentsVO> {
    public UserLikeNumAdapter(Context context, List<ReviewFloorDto.CommentsVO> data) {
        super(R.layout.like_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ReviewFloorDto.CommentsVO reviewFloorDto) {
        SimpleDraweeView mSimpleDraweeView = baseViewHolder.getView(R.id.sv);
        mSimpleDraweeView.setImageURI(Utils.getImgUrl(Constants.ServiceInterFace.IMG_BASE_URL + reviewFloorDto.getAuthor().getAvatar()));
    }
}
