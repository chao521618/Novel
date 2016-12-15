package yueshenginfo.com.mynovel.module.morenovel.view;

import yueshenginfo.com.IBaseView;
import yueshenginfo.com.mynovel.module.morenovel.dto.BooksDto;

/**
 * Created by huchao on 2016/12/12.
 * Email 1064224874@qq.com
 */
public interface BooksView extends IBaseView {
    /**
     *获取图书
     * @param isOk
     * @param booksVO
     */
    public void getBooksResult(boolean isOk, BooksDto booksVO);

}
