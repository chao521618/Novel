package yueshenginfo.com.mynovel.module.home.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.home.dto.BookChapterDto;
import yueshenginfo.com.mynovel.module.home.interfaces.BookChapterInterface;
import yueshenginfo.com.mynovel.module.home.model.BookChapterModel;

/**
 * Created by huchao on 2016/12/5.
 * Email 1064224874@qq.com
 */
public class BookChapterModelImpl extends IBaseModel implements BookChapterModel {
    private BookChapterInterface mBookContentInterface;

    @Override
    public void getBookChapter(Object params,Object obj) {
        mBookContentInterface = (BookChapterInterface) obj;
        mRequestManager.requestBookChapter(params, new Response.Listener<BookChapterDto>() {
            @Override
            public void onResponse(BookChapterDto dto) {
                    mBookContentInterface.getBookChapterResult(true, dto);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mBookContentInterface.getBookChapterResult(false, null);

            }
        });
    }
}
