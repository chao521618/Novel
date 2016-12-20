package yueshenginfo.com.mynovel.module.bookdetail.presenter;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.bookdetail.dto.BookDetailDto;
import yueshenginfo.com.mynovel.module.bookdetail.interfaces.BookDetailInterface;
import yueshenginfo.com.mynovel.module.bookdetail.model.BookDetailModel;
import yueshenginfo.com.mynovel.module.bookdetail.model.impl.BookDetailModelImpl;
import yueshenginfo.com.mynovel.module.bookdetail.view.BookDetailView;

/**
 * Created by huchao on 2016/12/20.
 * Email 1064224874@qq.com
 */
public class BookDetailPresenter extends IBasePresenter<BookDetailView> implements BookDetailInterface {
    private BookDetailModel mBookDetailModel;

    public BookDetailPresenter(BookDetailView bookDetailView) {
        super(bookDetailView);
    }

    @Override
    public void getBookDetailResult(boolean isOk, BookDetailDto bookDetailDto) {
        getView().getBookDetailResult(isOk, bookDetailDto);
    }

    public void getBookDetail(Object object) {
        mBookDetailModel.getBookDetail(object, BookDetailPresenter.this);
    }

    @Override
    public void initialized() {
        mBookDetailModel = new BookDetailModelImpl();
    }
}
