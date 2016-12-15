package yueshenginfo.com.mynovel.module.morenovel.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Map;

import yueshenginfo.com.IBaseModel;
import yueshenginfo.com.mynovel.module.morenovel.dto.BooksDto;
import yueshenginfo.com.mynovel.module.morenovel.interfaces.BooksInterface;
import yueshenginfo.com.mynovel.module.morenovel.model.BooksModel;

/**
 * Created by huchao on 2016/12/12.
 * Email 1064224874@qq.com
 */
public class BooksModelImpl extends IBaseModel implements BooksModel {
    private BooksInterface mBooksInterface;

    @Override
    public void getBooks(Map<String, Object> params, Object obj ) {
        mBooksInterface = (BooksInterface) obj;
            mRequestManager.requestBooksMore(params, new Response.Listener<BooksDto>() {
                @Override
                public void onResponse(BooksDto booksVO) {
                    if (booksVO.isOk()) {
                        mBooksInterface.getBooksResult(true, booksVO);
                    } else {
                        mBooksInterface.getBooksResult(false, booksVO);
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    mBooksInterface.getBooksResult(false, null);
                }
            });
        }

}
