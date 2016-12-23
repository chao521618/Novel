package yueshenginfo.com.mynovel.module.review.presenter;

import java.util.Map;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.review.dto.ReviewFloorDto;
import yueshenginfo.com.mynovel.module.review.interfaces.ReviewFloorInterface;
import yueshenginfo.com.mynovel.module.review.model.ReviewFloorModel;
import yueshenginfo.com.mynovel.module.review.model.impl.ReviewFloorModelImpl;
import yueshenginfo.com.mynovel.module.review.view.ReviewFloorView;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class ReviewFloorPresetner extends IBasePresenter<ReviewFloorView> implements ReviewFloorInterface {
    private ReviewFloorModel mReviewFloorModel;

    public ReviewFloorPresetner(ReviewFloorView reviewFloorView) {
        super(reviewFloorView);
    }

    @Override
    public void initialized() {
        mReviewFloorModel = new ReviewFloorModelImpl();
    }

    public void getReviewFloor(Map<String, Object> params) {
        mReviewFloorModel.getReviewFloor(params, ReviewFloorPresetner.this);
    }

    @Override
    public void getReviewFloorResult(boolean isOk, ReviewFloorDto dto) {
        getView().getReviewFloorResult(isOk, dto);
    }
}
