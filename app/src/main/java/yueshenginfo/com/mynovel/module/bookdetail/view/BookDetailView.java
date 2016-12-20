package yueshenginfo.com.mynovel.module.bookdetail.view;

import yueshenginfo.com.IBaseView;
import yueshenginfo.com.mynovel.module.bookdetail.dto.BookDetailDto;

/**
 * Created by huchao on 2016/12/20.
 * Email 1064224874@qq.com
 */
public interface BookDetailView extends IBaseView {
    /**
     * 获取书籍详情
     * @param isOk
     * @param bookDetailDto
     */
    public void getBookDetailResult(boolean isOk, BookDetailDto bookDetailDto);
}
