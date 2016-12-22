package yueshenginfo.com.mynovel.module.bookdetail.presenter;

import java.util.Map;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.bookdetail.interfaces.BookDetailReviewInterface;
import yueshenginfo.com.mynovel.module.bookdetail.model.BookDetailReviewModel;
import yueshenginfo.com.mynovel.module.bookdetail.model.impl.BookDetailReviewModelimpl;
import yueshenginfo.com.mynovel.module.bookdetail.view.BookDetailReviewView;
import yueshenginfo.com.mynovel.module.review.dto.ReviewDto;

/**
 * Created by huchao on 2016/12/22.
 * Email 1064224874@qq.com
 */
public class BookDetailReviewPresenter extends IBasePresenter<BookDetailReviewView> implements BookDetailReviewInterface {
    private BookDetailReviewModel mBookDetailReviewModel;

    public BookDetailReviewPresenter(BookDetailReviewView bookDetailReviewView) {
        super(bookDetailReviewView);
    }

    @Override
    public void getBookDetailReviewResult(boolean isOk, ReviewDto reviewDto) {
        getView().getBookDetailReviewResult(isOk, reviewDto);
    }

    public void getBookDetailReview(Map<String, Object> params) {
        mBookDetailReviewModel.getBookDetailReview(params, BookDetailReviewPresenter.this);
    }

    @Override
    public void initialized() {
        mBookDetailReviewModel = new BookDetailReviewModelimpl();
    }
}
