package yueshenginfo.com.mynovel.module.review.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.review.dto.UserReviewDto;
import yueshenginfo.com.mynovel.module.review.interfaces.UserReviewInterface;
import yueshenginfo.com.mynovel.module.review.model.UserReviewModel;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class UserReviewModelImpl extends IBaseModel implements UserReviewModel {
    private UserReviewInterface mUserReviewInterface;

    @Override
    public void getUserReview(Object object, Object obj) {
        mUserReviewInterface = (UserReviewInterface) obj;
        mRequestManager.requestUsrDetailReview(object, new Response.Listener<UserReviewDto>() {
            @Override
            public void onResponse(UserReviewDto dto) {
                if (dto.isOk()) {
                    mUserReviewInterface.getUserReviewViewResult(true, dto);
                } else {
                    mUserReviewInterface.getUserReviewViewResult(false, dto);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mUserReviewInterface.getUserReviewViewResult(false, null);
            }
        });
    }
}
