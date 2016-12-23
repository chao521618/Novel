package yueshenginfo.com.mynovel.module.review.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Map;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.review.dto.ReviewDto;
import yueshenginfo.com.mynovel.module.review.interfaces.MoreReviewInterface;
import yueshenginfo.com.mynovel.module.review.model.MoreReviewModel;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class MoreReviewModelImpl extends IBaseModel implements MoreReviewModel {
    private MoreReviewInterface moreReviewInterface;

    @Override
    public void getMoreReview(Map<String, Object> params, Object object) {
        moreReviewInterface = (MoreReviewInterface) object;
        mRequestManager.requestMoreReview(params, new Response.Listener<ReviewDto>() {
            @Override
            public void onResponse(ReviewDto dto) {
                if (dto.isOk()) {
                    moreReviewInterface.getMoreReviewResult(true, dto);
                } else {
                    moreReviewInterface.getMoreReviewResult(false, dto);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                moreReviewInterface.getMoreReviewResult(false, null);

            }
        });
    }
}
