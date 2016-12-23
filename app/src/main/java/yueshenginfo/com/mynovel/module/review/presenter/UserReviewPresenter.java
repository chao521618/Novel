package yueshenginfo.com.mynovel.module.review.presenter;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.review.dto.UserReviewDto;
import yueshenginfo.com.mynovel.module.review.interfaces.UserReviewInterface;
import yueshenginfo.com.mynovel.module.review.model.UserReviewModel;
import yueshenginfo.com.mynovel.module.review.model.impl.UserReviewModelImpl;
import yueshenginfo.com.mynovel.module.review.view.UserReviewView;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class UserReviewPresenter extends IBasePresenter<UserReviewView> implements UserReviewInterface {
    private UserReviewModel mUserReviewModel;

    public UserReviewPresenter(UserReviewView userReviewView) {
        super(userReviewView);
    }

    @Override
    public void initialized() {
        mUserReviewModel = new UserReviewModelImpl();
    }

    public void getUserReview(Object object) {
        mUserReviewModel.getUserReview(object, UserReviewPresenter.this);
    }

    @Override
    public void getUserReviewViewResult(boolean isOk, UserReviewDto dto) {
        getView().getUserReviewViewResult(isOk, dto);
    }
}
