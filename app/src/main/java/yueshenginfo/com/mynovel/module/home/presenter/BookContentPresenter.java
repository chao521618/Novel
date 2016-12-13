package yueshenginfo.com.mynovel.module.home.presenter;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.home.dto.BookContentDto;
import yueshenginfo.com.mynovel.module.home.interfaces.BookContentInterface;
import yueshenginfo.com.mynovel.module.home.model.BookContentModel;
import yueshenginfo.com.mynovel.module.home.model.impl.BookContentModelImpl;
import yueshenginfo.com.mynovel.module.home.view.BookContentView;

/**
 * Created by huchao on 2016/12/6.
 * Email 1064224874@qq.com
 */
public class BookContentPresenter extends IBasePresenter<BookContentView> implements BookContentInterface {
    private BookContentModel mBookContentModel;

    public BookContentPresenter(BookContentView bookContentView) {
        super(bookContentView);
    }

    @Override
    public void initialized() {
        mBookContentModel = new BookContentModelImpl();
    }

    public void getBookContent(Object params) {
        mBookContentModel.getBookContent(params, BookContentPresenter.this);

    }

    @Override
    public void getBookContentResult(boolean isOk, BookContentDto dto) {
            getView().getBookContentResult(isOk, dto);
    }


}
