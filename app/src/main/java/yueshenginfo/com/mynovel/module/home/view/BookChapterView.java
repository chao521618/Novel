package yueshenginfo.com.mynovel.module.home.view;

import yueshenginfo.com.IBaseView;
import yueshenginfo.com.mynovel.module.home.dto.BookChapterDto;

/**
 * Created by huchao on 2016/12/5.
 * Email 1064224874@qq.com
 */
public interface BookChapterView extends IBaseView {
    /**
     * 书的章节
     * @param isOk
     * @param dto
     */
    public void getBookChapterResult(boolean isOk, BookChapterDto dto);
}
