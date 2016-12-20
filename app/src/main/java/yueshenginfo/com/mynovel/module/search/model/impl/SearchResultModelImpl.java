package yueshenginfo.com.mynovel.module.search.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Map;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.search.dto.SeachBooksDto;
import yueshenginfo.com.mynovel.module.search.interfaces.SearchResultInterface;
import yueshenginfo.com.mynovel.module.search.model.SearchResultModel;

/**
 * Created by huchao on 2016/12/19.
 * Email 1064224874@qq.com
 */
public class SearchResultModelImpl extends IBaseModel implements SearchResultModel {
    private SearchResultInterface mSearchResultInterface;

    @Override
    public void getSearch(Map<String, Object> params, Object object) {
        mSearchResultInterface = (SearchResultInterface) object;
        mRequestManager.requestSearchResult(params, new Response.Listener<SeachBooksDto>() {
            @Override
            public void onResponse(SeachBooksDto dto) {
                if (dto.isOk()) {
                    mSearchResultInterface.getSearchResult(true, dto);
                } else {
                    mSearchResultInterface.getSearchResult(false, dto);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mSearchResultInterface.getSearchResult(false, null);
            }
        });
    }
}
