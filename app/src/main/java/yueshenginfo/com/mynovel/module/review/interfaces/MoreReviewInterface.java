package yueshenginfo.com.mynovel.module.review.interfaces;

import yueshenginfo.com.mynovel.module.review.dto.ReviewDto;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public interface MoreReviewInterface {
    /**
     * 更多评论
     * @param isOk
     * @param dto
     */
    public void getMoreReviewResult(boolean isOk, ReviewDto dto);
}
