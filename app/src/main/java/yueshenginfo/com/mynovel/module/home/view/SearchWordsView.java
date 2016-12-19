package yueshenginfo.com.mynovel.module.home.view;

import yueshenginfo.com.IBaseView;
import yueshenginfo.com.mynovel.module.home.dto.KeyWordsDto;

/**
 * Created by huchao on 2016/12/16.
 * Email 1064224874@qq.com
 */
public interface SearchWordsView extends IBaseView {
    /**
     * 获取搜索关键词
     * @param isOk
     * @param dto
     */
    public void getSearchWordsResult(boolean isOk, KeyWordsDto dto);
}
