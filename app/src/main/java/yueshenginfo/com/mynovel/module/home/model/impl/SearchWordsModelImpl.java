package yueshenginfo.com.mynovel.module.home.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Map;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.home.dto.KeyWordsDto;
import yueshenginfo.com.mynovel.module.home.interfaces.SearchWordsInterface;
import yueshenginfo.com.mynovel.module.home.model.SearchWordsModel;

/**
 * Created by huchao on 2016/12/16.
 * Email 1064224874@qq.com
 */
public class SearchWordsModelImpl extends IBaseModel implements SearchWordsModel {
    private SearchWordsInterface mSearchWordsInterface;

    @Override
    public void getSearchWords(Map<String, Object> params, Object object) {
        mSearchWordsInterface = (SearchWordsInterface) object;
        mRequestManager.requestSearchWords(params, new Response.Listener<KeyWordsDto>() {
            @Override
            public void onResponse(KeyWordsDto dto) {
                if (dto.isOk()) {
                    mSearchWordsInterface.getSearchWordsResult(true, dto);
                } else {
                    mSearchWordsInterface.getSearchWordsResult(true, dto);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mSearchWordsInterface.getSearchWordsResult(false,null);
            }
        });
    }

}
