package yueshenginfo.com.mynovel.module.home.interfaces;

import yueshenginfo.com.mynovel.module.home.dto.BookRecommendDto;

/**
 * Created by huchao on 2016/12/14.
 * Email 1064224874@qq.com
 */
public interface BooksRecommendInterface {
    /**
     * 图书推荐
     * @param isOk
     * @param booksVO
     */
    public void getBooksRecommendResult(boolean isOk, BookRecommendDto booksVO);
}
