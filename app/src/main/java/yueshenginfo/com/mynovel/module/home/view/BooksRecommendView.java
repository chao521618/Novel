package yueshenginfo.com.mynovel.module.home.view;

import yueshenginfo.com.IBaseView;
import yueshenginfo.com.mynovel.module.home.dto.BookRecommendDto;

/**
 * Created by huchao on 2016/12/14.
 * Email 1064224874@qq.com
 */
public interface BooksRecommendView extends IBaseView {
    /**
     * 图书推荐
     * @param isOk
     * @param booksVO
     */
    public void getBooksReconnmendResult(boolean isOk, BookRecommendDto booksVO);
}
