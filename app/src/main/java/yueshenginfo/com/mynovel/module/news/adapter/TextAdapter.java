package yueshenginfo.com.mynovel.module.news.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yueshenginfo.com.mynovel.R;

/**
 * Created by huchao on 2016/12/29.
 * Email 1064224874@qq.com
 */
public class TextAdapter extends BaseQuickAdapter<String> {

    public TextAdapter(Context layoutResId, List<String> data) {
        super(R.layout.text_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
baseViewHolder.setText(R.id.tv,s);
    }
}
