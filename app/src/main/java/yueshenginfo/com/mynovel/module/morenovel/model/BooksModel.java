package yueshenginfo.com.mynovel.module.morenovel.model;

import java.util.Map;

/**
 * Created by huchao on 2016/12/12.
 * Email 1064224874@qq.com
 */
public interface BooksModel {
    /**
     * 获取图书
     * @param params
     * @param obj
     */
    public void getBooks(Map<String, Object> params, Object obj);
}
