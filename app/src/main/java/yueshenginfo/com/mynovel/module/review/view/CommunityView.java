package yueshenginfo.com.mynovel.module.review.view;

import yueshenginfo.com.IBaseView;
import yueshenginfo.com.mynovel.module.review.dto.CommunityDto;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public interface CommunityView extends IBaseView {
    /**
     * 友圈
     * @param isOk
     * @param dto
     */
    public void getCommunityResult(boolean isOk, CommunityDto dto);
}
