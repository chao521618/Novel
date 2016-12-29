package yueshenginfo.com.mynovel.module.news.adapter;

import android.content.Context;
import android.net.Uri;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.news.dto.NewsDto;
import yueshenginfo.com.mynovel.publics.utils.DateUtil;

/**
 * Created by huchao on 2016/12/28.
 * Email 1064224874@qq.com
 */
public class NewsListAdapter extends BaseQuickAdapter<NewsDto.T1348647909107Dto> {
    public NewsListAdapter(Context layoutResId, List<NewsDto.T1348647909107Dto> data) {
        super(R.layout.item_news_list, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, NewsDto.T1348647909107Dto s) {
        baseViewHolder.setText(R.id.news_title, s.getTitle());
        baseViewHolder.setText(R.id.news_origin, s.getSource());
        SimpleDraweeView mSimpleDraweeView = baseViewHolder.getView(R.id.news_img);

      String ss=  DateUtil.getOther(DateUtil.str2Calendar(s.getPtime()).getTimeInMillis());
        baseViewHolder.setText(R.id.news_public_time,ss);
        mSimpleDraweeView.setImageURI(Uri.parse(s.getImgsrc()));
    }
}
