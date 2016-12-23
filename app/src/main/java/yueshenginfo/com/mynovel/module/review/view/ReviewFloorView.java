package yueshenginfo.com.mynovel.module.review.view;

import yueshenginfo.com.IBaseView;
import yueshenginfo.com.mynovel.module.review.dto.ReviewFloorDto;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public interface ReviewFloorView extends IBaseView {
    /**
     * 评论楼层请求
     * @param isOk
     * @param dto
     */
    public void getReviewFloorResult(boolean isOk, ReviewFloorDto dto);
}
