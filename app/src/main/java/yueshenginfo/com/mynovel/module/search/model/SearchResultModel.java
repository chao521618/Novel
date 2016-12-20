package yueshenginfo.com.mynovel.module.search.model;

import java.util.Map;

/**
 * Created by huchao on 2016/12/19.
 * Email 1064224874@qq.com
 */
public interface SearchResultModel {
    /**
     * 搜索页面的请求
     * @param params
     * @param object
     */
    public void getSearch(Map<String,Object> params,Object object);
}
