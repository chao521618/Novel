package yueshenginfo.com.mynovel.module.news.model.impl;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Map;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.news.dto.NewsDto;
import yueshenginfo.com.mynovel.module.news.interfaces.NewsInterface;
import yueshenginfo.com.mynovel.module.news.model.NewsModel;

/**
 * Created by huchao on 2016/12/29.
 * Email 1064224874@qq.com
 */
public class NewsModelImpl extends IBaseModel implements NewsModel {
    public NewsInterface mNewsInterface;

    @Override
    public void getNews(Map<String, Object> params, Object object) {
        mNewsInterface = (NewsInterface) object;
        mRequestManager.requestNewsList(params, new Response.Listener<NewsDto>() {
            @Override
            public void onResponse(NewsDto mNewsDto) {
                mNewsInterface.getNewsResult(true, mNewsDto);
                Log.e("++++++++++",mNewsDto.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mNewsInterface.getNewsResult(false, null);
                Log.e("----------",volleyError.getMessage());

            }
        });
    }
}
