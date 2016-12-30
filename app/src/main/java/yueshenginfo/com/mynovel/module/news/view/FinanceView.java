package yueshenginfo.com.mynovel.module.news.view;

import yueshenginfo.com.IBaseView;
import yueshenginfo.com.mynovel.module.news.dto.FinanceNewsDto;

/**
 * Created by huchao on 2016/12/30.
 * Email 1064224874@qq.com
 */
public interface FinanceView extends IBaseView {
    /**
     * 新闻请求
     * @param isOk
     * @param dto
     */
    public void getFinanceResult(boolean isOk, FinanceNewsDto dto);
}
