package yueshenginfo.com.mynovel.module.review.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Map;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.review.dto.ReviewFloorDto;
import yueshenginfo.com.mynovel.module.review.interfaces.ReviewFloorInterface;
import yueshenginfo.com.mynovel.module.review.model.ReviewFloorModel;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class ReviewFloorModelImpl extends IBaseModel implements ReviewFloorModel {
    private ReviewFloorInterface mReviewFloorInterface;

    @Override
    public void getReviewFloor(Map<String, Object> params, Object object) {
        mReviewFloorInterface = (ReviewFloorInterface) object;
        mRequestManager.requestReviewFloor(params, new Response.Listener<ReviewFloorDto>() {
            @Override
            public void onResponse(ReviewFloorDto dto) {
                if (dto.isOk()) {
                    mReviewFloorInterface.getReviewFloorResult(true, dto);
                } else {
                    mReviewFloorInterface.getReviewFloorResult(false, dto);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mReviewFloorInterface.getReviewFloorResult(false, null);
            }
        });
    }
}
