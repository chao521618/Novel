package yueshenginfo.com.mynovel.module.news.view;

import yueshenginfo.com.IBaseView;
import yueshenginfo.com.mynovel.module.news.dto.NewsDto;

/**
 * Created by huchao on 2016/12/29.
 * Email 1064224874@qq.com
 */
public interface NewsView extends IBaseView {
    /**
     * 新闻请求
     * @param isOk
     * @param dto
     */
    public void getNewsResult(boolean isOk, NewsDto dto);
}
