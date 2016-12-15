package yueshenginfo.com.mynovel.module.home.view;

import yueshenginfo.com.IBaseView;
import yueshenginfo.com.mynovel.module.home.dto.AllLookBooksDto;

/**
 * Created by huchao on 2016/12/15.
 * Email 1064224874@qq.com
 */
public interface AllLookBooksView extends IBaseView {
    /**
     * 获取大家都在看的书
     * @param isOk
     * @param dto
     */
    public void getAllLookBooksResult(boolean isOk, AllLookBooksDto dto);
}
