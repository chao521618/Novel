package yueshenginfo.com.mynovel.module.news.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yueshenginfo.com.mynovel.R;

/**
 * Created by huchao on 2016/12/28.
 * Email 1064224874@qq.com
 */
public class NewsListAdapter extends BaseQuickAdapter<String> {
    public NewsListAdapter(Context layoutResId, List<String> data) {
        super(R.layout.item_news_list, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.tv, s);
    }
}
