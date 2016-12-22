package yueshenginfo.com.mynovel.module.bookdetail.view;

import yueshenginfo.com.IBaseView;
import yueshenginfo.com.mynovel.module.review.dto.ReviewDto;

/**
 * Created by huchao on 2016/12/22.
 * Email 1064224874@qq.com
 */
public interface BookDetailReviewView extends IBaseView {
    /**
     * 获取书籍详情评论
     * @param isOk
     * @param reviewDto
     */
    public void getBookDetailReviewResult(boolean isOk, ReviewDto reviewDto);
}
