package yueshenginfo.com.mynovel.module.home.interfaces;

import yueshenginfo.com.mynovel.module.home.dto.BookContentDto;

/**
 * Created by huchao on 2016/12/6.
 * Email 1064224874@qq.com
 */
public interface BookContentInterface {

    /**
     * 书的某一章内容
     * @param isOk
     * @param dto
     */
    public void getBookContentResult(boolean isOk, BookContentDto dto);
}
