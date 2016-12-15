package yueshenginfo.com.mynovel.module.home.model;

import java.util.Map;

/**
 * Created by huchao on 2016/12/14.
 * Email 1064224874@qq.com
 */
public interface BooksRecommendModel {
    /**
     * 获取图书推荐
     * @param params
     * @param obj
     */
    public void getBooksRecommend(Map<String, Object> params, Object obj);
}
