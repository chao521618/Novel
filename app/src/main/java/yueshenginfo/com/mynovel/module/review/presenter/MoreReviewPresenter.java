package yueshenginfo.com.mynovel.module.review.presenter;

import java.util.Map;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.review.dto.ReviewDto;
import yueshenginfo.com.mynovel.module.review.interfaces.MoreReviewInterface;
import yueshenginfo.com.mynovel.module.review.model.MoreReviewModel;
import yueshenginfo.com.mynovel.module.review.model.impl.MoreReviewModelImpl;
import yueshenginfo.com.mynovel.module.review.view.MoreReviewView;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class MoreReviewPresenter extends IBasePresenter<MoreReviewView> implements MoreReviewInterface {
    private MoreReviewModel mMoreReviewModel;

    public MoreReviewPresenter(MoreReviewView moreReviewView) {
        super(moreReviewView);
    }

    @Override
    public void initialized() {
        mMoreReviewModel = new MoreReviewModelImpl();
    }

    public void getMoreReview(Map<String, Object> params) {
        mMoreReviewModel.getMoreReview(params,MoreReviewPresenter.this);
    }

    @Override
    public void getMoreReviewResult(boolean isOk, ReviewDto dto) {
        getView().getMoreReviewResult(isOk, dto);
    }
}
