package yueshenginfo.com.mynovel.module.news.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Map;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.news.dto.HeadsNewsDto;
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

        mRequestManager.requestNewsList(params, new Response.Listener<HeadsNewsDto>() {
            @Override
            public void onResponse(HeadsNewsDto mNewsDto) {
                mNewsInterface.getNewsResult(true, mNewsDto);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mNewsInterface.getNewsResult(false, null);

            }
        });
    }


}
