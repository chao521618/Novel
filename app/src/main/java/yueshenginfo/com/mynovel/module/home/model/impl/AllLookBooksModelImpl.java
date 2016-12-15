package yueshenginfo.com.mynovel.module.home.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Map;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.home.dto.AllLookBooksDto;
import yueshenginfo.com.mynovel.module.home.interfaces.AllLookBooksInterface;
import yueshenginfo.com.mynovel.module.home.model.AllLookBooksModel;

/**
 * Created by huchao on 2016/12/15.
 * Email 1064224874@qq.com
 */
public class AllLookBooksModelImpl extends IBaseModel implements AllLookBooksModel {
    private AllLookBooksInterface mAllLookBooksInterface;

    @Override
    public void getAllLookBooks(Map<String, Object> params, Object object) {
        mAllLookBooksInterface = (AllLookBooksInterface) object;
        mRequestManager.requestAllLookBooks(params, new Response.Listener<AllLookBooksDto>() {
            @Override
            public void onResponse(AllLookBooksDto mAllLookBooksDto) {
                if (mAllLookBooksDto.isOk()) {
                    mAllLookBooksInterface.getAllLookBooksResult(true, mAllLookBooksDto);
                } else {
                    mAllLookBooksInterface.getAllLookBooksResult(false, mAllLookBooksDto);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mAllLookBooksInterface.getAllLookBooksResult(false, null);
            }
        });
    }
}
