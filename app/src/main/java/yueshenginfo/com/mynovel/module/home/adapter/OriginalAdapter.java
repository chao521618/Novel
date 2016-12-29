package yueshenginfo.com.mynovel.module.home.adapter;

import android.content.Context;
import android.widget.FrameLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.dto.VideoListDto;
import yueshenginfo.com.mynovel.publics.utils.Utils;

/**
 * Created by huchao on 2016/12/27.
 * Email 1064224874@qq.com
 */
public class OriginalAdapter extends BaseQuickAdapter<VideoListDto.V9LG4B3A0VO> {

    public OriginalAdapter(Context layoutResId, List<VideoListDto.V9LG4B3A0VO> data) {
        super(R.layout.original_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, VideoListDto.V9LG4B3A0VO originalDto) {
        baseViewHolder.setText(R.id.item_original_title, originalDto.getTitle());
        baseViewHolder.setText(R.id.item_company_tv, originalDto.getTopicName());
        SimpleDraweeView mSimpleDraweeView = baseViewHolder.getView(R.id.item_original_img);
        SimpleDraweeView mSimpleDraweeView1 = baseViewHolder.getView(R.id.item_company_img);
        int width = Utils.getScreenWidth(mContext);
        mSimpleDraweeView.setLayoutParams(new FrameLayout.LayoutParams(width, width * 4 / 9));
        mSimpleDraweeView.setImageURI(Utils.getImgUrl(originalDto.getCover()));
        mSimpleDraweeView1.setImageURI(Utils.getImgUrl(originalDto.getTopicImg()));
    }
}
