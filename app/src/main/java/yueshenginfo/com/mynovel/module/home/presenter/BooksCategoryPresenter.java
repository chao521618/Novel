package yueshenginfo.com.mynovel.module.home.presenter;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.home.dto.BooksCategoryDto;
import yueshenginfo.com.mynovel.module.home.interfaces.BooksCategoryInterface;
import yueshenginfo.com.mynovel.module.home.model.BooksCategoryModel;
import yueshenginfo.com.mynovel.module.home.model.impl.BooksCategoryModelImpl;
import yueshenginfo.com.mynovel.module.home.view.BooksCategoryView;

/**
 * Created by huchao on 2016/12/7.
 * Email 1064224874@qq.com
 */
public class BooksCategoryPresenter extends IBasePresenter<BooksCategoryView> implements BooksCategoryInterface {
    private BooksCategoryModel mBooksCategoryModel;

    public BooksCategoryPresenter(BooksCategoryView booksCategoryView) {
        super(booksCategoryView);
    }

    @Override
    public void getBooksCategoryResult(boolean isOk, BooksCategoryDto dto) {
        getView().getBooksCategoryResult(isOk, dto);
    }

    public void getBooksCategory(Object o) {
        mBooksCategoryModel.getBooksCategory(o,BooksCategoryPresenter.this);
    }

    @Override
    public void initialized() {
        mBooksCategoryModel = new BooksCategoryModelImpl();
    }
}
