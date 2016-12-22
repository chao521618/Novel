package yueshenginfo.com.mynovel.module.bookdetail.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Map;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.bookdetail.interfaces.BookDetailReviewInterface;
import yueshenginfo.com.mynovel.module.bookdetail.model.BookDetailReviewModel;
import yueshenginfo.com.mynovel.module.review.dto.ReviewDto;

/**
 * Created by huchao on 2016/12/22.
 * Email 1064224874@qq.com
 */
public class BookDetailReviewModelimpl extends IBaseModel implements BookDetailReviewModel {
    private BookDetailReviewInterface mBookDetailReviewInterface;

    @Override
    public void getBookDetailReview(Map<String, Object> params, Object object) {
        mBookDetailReviewInterface = (BookDetailReviewInterface) object;
        mRequestManager.requestBookDetailReview(params, new Response.Listener<ReviewDto>() {
            @Override
            public void onResponse(ReviewDto reviewDto) {
                if (reviewDto.isOk()) {
                    mBookDetailReviewInterface.getBookDetailReviewResult(true,reviewDto);
                }else {
                    mBookDetailReviewInterface.getBookDetailReviewResult(false,reviewDto);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mBookDetailReviewInterface.getBookDetailReviewResult(false,null);

            }
        });
    }
}
