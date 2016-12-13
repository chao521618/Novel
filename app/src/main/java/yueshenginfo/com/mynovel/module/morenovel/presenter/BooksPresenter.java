package yueshenginfo.com.mynovel.module.morenovel.presenter;

import java.util.Map;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.morenovel.dto.BooksDto;
import yueshenginfo.com.mynovel.module.morenovel.interfaces.BooksInterface;
import yueshenginfo.com.mynovel.module.morenovel.model.BooksModel;
import yueshenginfo.com.mynovel.module.morenovel.model.impl.BooksModelImpl;
import yueshenginfo.com.mynovel.module.morenovel.view.BooksView;

/**
 * Created by huchao on 2016/12/12.
 * Email 1064224874@qq.com
 */
public class BooksPresenter extends IBasePresenter<BooksView> implements BooksInterface {
    private BooksModel mBooksModel;

    public BooksPresenter(BooksView booksView) {
        super(booksView);
    }


    @Override
    public void initialized() {
        mBooksModel = new BooksModelImpl();
    }

    public void getBooks(Map<String, Object> params) {
        mBooksModel.getBooks(params, BooksPresenter.this);
    }

    @Override
    public void getBooksResult(boolean isOk, BooksDto booksVO) {
        getView().getBooksResult(isOk, booksVO);
    }
}
