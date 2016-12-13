package yueshenginfo.com.mynovel.module.home.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.home.dto.BooksCategoryDto;
import yueshenginfo.com.mynovel.module.home.interfaces.BooksCategoryInterface;
import yueshenginfo.com.mynovel.module.home.model.BooksCategoryModel;

/**
 * Created by huchao on 2016/12/7.
 * Email 1064224874@qq.com
 */
public class BooksCategoryModelImpl extends IBaseModel implements BooksCategoryModel {
    private BooksCategoryInterface mBooksCategoryInterface;

    @Override
    public void getBooksCategory(Object object, Object obj) {
        mBooksCategoryInterface = (BooksCategoryInterface) obj;
        mRequestManager.requestBooksCategory(object, new Response.Listener<BooksCategoryDto>() {
            @Override
            public void onResponse(BooksCategoryDto booksCategoryDto) {
                if (booksCategoryDto.isOk()){
                    mBooksCategoryInterface.getBooksCategoryResult(true,booksCategoryDto);
                }else {
                    mBooksCategoryInterface.getBooksCategoryResult(false,booksCategoryDto);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mBooksCategoryInterface.getBooksCategoryResult(false,null);
            }
        });
    }
}
