package yueshenginfo.com.mynovel.module.home.presenter;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.home.dto.BookChapterDto;
import yueshenginfo.com.mynovel.module.home.interfaces.BookChapterInterface;
import yueshenginfo.com.mynovel.module.home.model.BookChapterModel;
import yueshenginfo.com.mynovel.module.home.model.impl.BookChapterModelImpl;
import yueshenginfo.com.mynovel.module.home.view.BookChapterView;

/**
 * Created by huchao on 2016/12/5.
 * Email 1064224874@qq.com
 */
public class BookChapterPresenter extends IBasePresenter<BookChapterView> implements BookChapterInterface {
    private BookChapterModel mBookContentModel;

    public BookChapterPresenter(BookChapterView bookContentView) {
        super(bookContentView);
    }

    @Override
    public void initialized() {
        mBookContentModel = new BookChapterModelImpl();
    }

    public void getBookChapter(final String bookId) {
        mBookContentModel.getBookChapter(bookId,BookChapterPresenter.this);

    }

    @Override
    public void getBookChapterResult(boolean isOk, BookChapterDto dto) {
            getView().getBookChapterResult(isOk, dto);
    }

}
