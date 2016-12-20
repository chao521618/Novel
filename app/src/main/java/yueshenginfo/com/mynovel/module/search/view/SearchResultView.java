package yueshenginfo.com.mynovel.module.search.view;

import yueshenginfo.com.IBaseView;
import yueshenginfo.com.mynovel.module.search.dto.SeachBooksDto;

/**
 * Created by huchao on 2016/12/19.
 * Email 1064224874@qq.com
 */
public interface SearchResultView extends IBaseView {
    /**
     * 搜索结果页面的请求
     * @param isOk
     * @param dto
     */
    public void getSearchResult(boolean isOk, SeachBooksDto dto);
}
