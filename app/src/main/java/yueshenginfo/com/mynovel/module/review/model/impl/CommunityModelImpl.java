package yueshenginfo.com.mynovel.module.review.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Map;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.review.dto.CommunityDto;
import yueshenginfo.com.mynovel.module.review.interfaces.CommunityInterface;
import yueshenginfo.com.mynovel.module.review.model.CommunityModel;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class CommunityModelImpl extends IBaseModel implements CommunityModel {
    private CommunityInterface mCommunityInterface;

    @Override
    public void getCommunity(Map<String, Object> params, Object obj) {
        mCommunityInterface = (CommunityInterface) obj;
        mRequestManager.requestCommunity(params, new Response.Listener<CommunityDto>() {
            @Override
            public void onResponse(CommunityDto dto) {
                if (dto.isOk()) {
                    mCommunityInterface.getCommunityResult(true, dto);
                } else {
                    mCommunityInterface.getCommunityResult(false, dto);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mCommunityInterface.getCommunityResult(false, null);
            }
        });
    }
}
