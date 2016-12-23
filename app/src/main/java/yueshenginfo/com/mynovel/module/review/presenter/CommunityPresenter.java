package yueshenginfo.com.mynovel.module.review.presenter;

import java.util.Map;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.review.dto.CommunityDto;
import yueshenginfo.com.mynovel.module.review.interfaces.CommunityInterface;
import yueshenginfo.com.mynovel.module.review.model.CommunityModel;
import yueshenginfo.com.mynovel.module.review.model.impl.CommunityModelImpl;
import yueshenginfo.com.mynovel.module.review.view.CommunityView;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class CommunityPresenter extends IBasePresenter<CommunityView> implements CommunityInterface {
    private CommunityModel communityModel;
    public CommunityPresenter(CommunityView communityView) {
        super(communityView);
    }

    @Override
    public void getCommunityResult(boolean isOk, CommunityDto dto) {
getView().getCommunityResult(isOk,dto);
    }
public void getCommunity(Map<String,Object> params){
    communityModel.getCommunity(params, CommunityPresenter.this);
}
    @Override
    public void initialized() {
        communityModel=new CommunityModelImpl();
    }
}
