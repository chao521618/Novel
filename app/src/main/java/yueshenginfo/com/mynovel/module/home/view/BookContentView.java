package yueshenginfo.com.mynovel.module.home.view;

import yueshenginfo.com.IBaseView;
import yueshenginfo.com.mynovel.module.home.dto.BookContentDto;

/**
 * Created by huchao on 2016/12/5.
 * Email 1064224874@qq.com
 */
public interface BookContentView extends IBaseView {
    /**
     * 书内容
     * @param isOk
     * @param dto
     */
    public void getBookContentResult(boolean isOk, BookContentDto dto);
}
