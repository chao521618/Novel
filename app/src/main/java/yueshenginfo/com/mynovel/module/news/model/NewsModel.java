package yueshenginfo.com.mynovel.module.news.model;

import java.util.Map;

/**
 * Created by huchao on 2016/12/29.
 * Email 1064224874@qq.com
 */
public interface NewsModel {
    /**
     * 新闻请求
     * @param params
     * @param object
     */
    public void getNews(Map<String,Object> params,Object object);
}
