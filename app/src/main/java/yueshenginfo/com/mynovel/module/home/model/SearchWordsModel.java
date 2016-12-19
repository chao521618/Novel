package yueshenginfo.com.mynovel.module.home.model;

import java.util.Map;

/**
 * Created by huchao on 2016/12/16.
 * Email 1064224874@qq.com
 */
public interface SearchWordsModel {
    /**
     * 获取搜索关键词
     * @param params
     * @param object
     */
    public void getSearchWords(Map<String,Object> params, Object object);
}
