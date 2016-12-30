package yueshenginfo.com.mynovel.module.news.interfaces;

import yueshenginfo.com.mynovel.module.news.dto.FinanceNewsDto;

/**
 * Created by huchao on 2016/12/30.
 * Email 1064224874@qq.com
 */
public interface FinanceInterface {
    /**
     * 新闻请求
     * @param isOk
     * @param dto
     */
    public void getFinanceResult(boolean isOk, FinanceNewsDto dto);
}
