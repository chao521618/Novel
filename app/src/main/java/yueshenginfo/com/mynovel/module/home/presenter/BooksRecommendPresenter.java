package yueshenginfo.com.mynovel.module.home.presenter;

import java.util.Map;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.home.dto.BookRecommendDto;
import yueshenginfo.com.mynovel.module.home.interfaces.BooksRecommendInterface;
import yueshenginfo.com.mynovel.module.home.model.BooksRecommendModel;
import yueshenginfo.com.mynovel.module.home.model.impl.BooksRecommendModelImpl;
import yueshenginfo.com.mynovel.module.home.view.BooksRecommendView;

/**
 * Created by huchao on 2016/12/14.
 * Email 1064224874@qq.com
 */
public class BooksRecommendPresenter extends IBasePresenter<BooksRecommendView> implements BooksRecommendInterface {
    private BooksRecommendModel mBooksRecommendModel;

    public BooksRecommendPresenter(BooksRecommendView booksRecommendView) {
        super(booksRecommendView);
    }

    @Override
    public void getBooksRecommendResult(boolean isOk, BookRecommendDto booksVO) {
        getView().getBooksReconnmendResult(isOk, booksVO);
    }

    public void getBookRecommend(Map<String, Object> params) {
        mBooksRecommendModel.getBooksRecommend(params, BooksRecommendPresenter.this);
    }

    @Override
    public void initialized() {
        mBooksRecommendModel = new BooksRecommendModelImpl();
    }
}
