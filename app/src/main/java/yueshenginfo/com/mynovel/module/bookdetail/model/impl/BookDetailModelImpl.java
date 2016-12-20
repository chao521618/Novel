package yueshenginfo.com.mynovel.module.bookdetail.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.bookdetail.dto.BookDetailDto;
import yueshenginfo.com.mynovel.module.bookdetail.interfaces.BookDetailInterface;
import yueshenginfo.com.mynovel.module.bookdetail.model.BookDetailModel;

/**
 * Created by huchao on 2016/12/20.
 * Email 1064224874@qq.com
 */
public class BookDetailModelImpl extends IBaseModel implements BookDetailModel {
    private BookDetailInterface mBookDetailInterface;

    @Override
    public void getBookDetail(Object object, Object obj) {
        mBookDetailInterface = (BookDetailInterface) obj;
        mRequestManager.requestBookDetail(object, new Response.Listener<BookDetailDto>() {
            @Override
            public void onResponse(BookDetailDto bookDetailDto) {
                // 未判断返回数据是否成功,默认为成功
                mBookDetailInterface.getBookDetailResult(true, bookDetailDto);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mBookDetailInterface.getBookDetailResult(false, null);
            }
        });
    }
}
