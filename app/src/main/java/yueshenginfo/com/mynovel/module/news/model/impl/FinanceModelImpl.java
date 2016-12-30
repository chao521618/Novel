package yueshenginfo.com.mynovel.module.news.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Map;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.news.dto.FinanceNewsDto;
import yueshenginfo.com.mynovel.module.news.interfaces.FinanceInterface;
import yueshenginfo.com.mynovel.module.news.model.FinanceModel;

/**
 * Created by huchao on 2016/12/29.
 * Email 1064224874@qq.com
 */
public class FinanceModelImpl extends IBaseModel implements FinanceModel {
    public FinanceInterface mFinanceInterface;

    @Override
    public void getFinance(Map<String, Object> params, Object object) {
        mFinanceInterface = (FinanceInterface) object;
        mRequestManager.requestFinanceNewsList(params, new Response.Listener<FinanceNewsDto>() {
            @Override
            public void onResponse(FinanceNewsDto mNewsDto) {
                mFinanceInterface.getFinanceResult(true, mNewsDto);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mFinanceInterface.getFinanceResult(false, null);
            }
        });
    }


}
