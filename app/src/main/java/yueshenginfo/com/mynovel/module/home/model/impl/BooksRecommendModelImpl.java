package yueshenginfo.com.mynovel.module.home.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Map;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.home.dto.BookRecommendDto;
import yueshenginfo.com.mynovel.module.home.interfaces.BooksRecommendInterface;
import yueshenginfo.com.mynovel.module.home.model.BooksRecommendModel;

/**
 * Created by huchao on 2016/12/14.
 * Email 1064224874@qq.com
 */
public class BooksRecommendModelImpl extends IBaseModel implements BooksRecommendModel {
    private BooksRecommendInterface mBooksRecommendInterface;

    @Override
    public void getBooksRecommend(Map<String, Object> params, Object obj) {
        mBooksRecommendInterface = (BooksRecommendInterface) obj;
        mRequestManager.requestHomeRecommendBooks(params, new Response.Listener<BookRecommendDto>() {
            @Override
            public void onResponse(BookRecommendDto booksCategoryDto) {
                if (booksCategoryDto.isOk()) {
                    mBooksRecommendInterface.getBooksRecommendResult(true, booksCategoryDto);
                } else {
                    mBooksRecommendInterface.getBooksRecommendResult(false, booksCategoryDto);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mBooksRecommendInterface.getBooksRecommendResult(false, null);
            }
        });
    }
}
