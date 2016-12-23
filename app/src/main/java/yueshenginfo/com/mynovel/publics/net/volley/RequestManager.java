package yueshenginfo.com.mynovel.publics.net.volley;

import android.util.Log;

import com.android.volley.Response;

import java.util.Map;

import yueshenginfo.com.mynovel.module.bookdetail.dto.BookDetailDto;
import yueshenginfo.com.mynovel.module.home.dto.AllLookBooksDto;
import yueshenginfo.com.mynovel.module.home.dto.BookChapterDto;
import yueshenginfo.com.mynovel.module.home.dto.BookContentDto;
import yueshenginfo.com.mynovel.module.home.dto.BookRecommendDto;
import yueshenginfo.com.mynovel.module.home.dto.BooksCategoryDto;
import yueshenginfo.com.mynovel.module.home.dto.KeyWordsDto;
import yueshenginfo.com.mynovel.module.morenovel.dto.BooksDto;
import yueshenginfo.com.mynovel.module.review.dto.ReviewDto;
import yueshenginfo.com.mynovel.module.review.dto.ReviewFloorDto;
import yueshenginfo.com.mynovel.module.review.dto.UserReviewDto;
import yueshenginfo.com.mynovel.module.search.dto.SeachBooksDto;
import yueshenginfo.com.mynovel.publics.common.Constants;
import yueshenginfo.com.mynovel.publics.utils.EmptyUtils;

/**
 * Created by huchao on 2016/12/5.
 * Email 1064224874@qq.com
 */
public class RequestManager {
    private static RequestManager mRequestManager;

    public static RequestManager getInstance() {
        if (EmptyUtils.isEmpty(mRequestManager)) {
            mRequestManager = new RequestManager();
        }
        return mRequestManager;
    }

    /**
     * 初始化
     */
    private RequestManager() {
    }
    // -------------------------请求服务器的方法写在此下面---------------------------------------------

    /**
     * 获取书籍章节
     */
    public void requestBookChapter(Object params,
                                   Response.Listener<BookChapterDto> listener, Response.ErrorListener errorListener) {
        RequestGet<BookChapterDto> request = new RequestGet<>(returnGetUrl(
                Constants.ServiceInterFace.GetBookChapterUrl, params), BookChapterDto.class,
                listener, errorListener);
        /** 添加标签 **/
        request.setTag(Constants.RequestTag.GetBookChapterTag);
        /** 添加执行 **/
        IVolley.getRequestQueuemanager().add(request);
    }

    /**
     * 获取书的某一章内容
     */
    public void requestBookContent(Object params,
                                   Response.Listener<BookContentDto> listener, Response.ErrorListener errorListener) {
        RequestGet<BookContentDto> request = new RequestGet<>(returnGetUrl(
                Constants.ServiceInterFace.GetBookContentUrl, params), BookContentDto.class,
                listener, errorListener);
        /** 添加标签 **/
        request.setTag(Constants.RequestTag.GetBookContentTag);
        /** 添加执行 **/
        IVolley.getRequestQueuemanager().add(request);
    }

    /**
     * 获取书籍类别
     */
    public void requestBooksCategory(Object params,
                                     Response.Listener<BooksCategoryDto> listener, Response.ErrorListener errorListener) {
        RequestGet<BooksCategoryDto> request = new RequestGet<>(returnGetUrl(
                Constants.ServiceInterFace.GetBooksCategoryUrl, params), BooksCategoryDto.class,
                listener, errorListener);
        /** 添加标签 **/
        request.setTag(Constants.RequestTag.GetBooksCategoryTag);
        /** 添加执行 **/
        IVolley.getRequestQueuemanager().add(request);
    }

    /**
     * 获取书城中的更多
     */
    public void requestBooksMore(Map<String, Object> params,
                                 Response.Listener<BooksDto> listener, Response.ErrorListener errorListener) {
        RequestGet<BooksDto> request = new RequestGet<>(returnGetUrl1(
                Constants.ServiceInterFace.GetBooksMoreUrl, params), BooksDto.class,
                listener, errorListener);
        /** 添加标签 **/
        request.setTag(Constants.RequestTag.GetBooksMoreTag);
        /** 添加执行 **/
        IVolley.getRequestQueuemanager().add(request);
    }

    /**
     * 获取首页推荐图书
     */
    public void requestHomeRecommendBooks(Map<String, Object> params,
                                          Response.Listener<BookRecommendDto> listener, Response.ErrorListener errorListener) {
        RequestGet<BookRecommendDto> request = new RequestGet<>(returnGetUrl1(
                Constants.ServiceInterFace.GetBooksRecommendUrl, params), BookRecommendDto.class,
                listener, errorListener);
        /** 添加标签 **/
        request.setTag(Constants.RequestTag.GetBooksRecommendTag);
        /** 添加执行 **/
        IVolley.getRequestQueuemanager().add(request);
    }

    /**
     * 获取大家都在看的书
     */
    public void requestAllLookBooks(Map<String, Object> params,
                                    Response.Listener<AllLookBooksDto> listener, Response.ErrorListener errorListener) {
        RequestGet<AllLookBooksDto> request = new RequestGet<>(returnGetUrl1(
                Constants.ServiceInterFace.GetAllLookBooksUrl, params), AllLookBooksDto.class,
                listener, errorListener);
        /** 添加标签 **/
        request.setTag(Constants.RequestTag.GetAllLookBooksTag);
        /** 添加执行 **/
        IVolley.getRequestQueuemanager().add(request);
    }

    /**
     * 获取搜索关键词
     */
    public void requestSearchWords(Map<String, Object> params,
                                   Response.Listener<KeyWordsDto> listener, Response.ErrorListener errorListener) {
        RequestGet<KeyWordsDto> request = new RequestGet<>(returnGetUrl1(
                Constants.ServiceInterFace.GetSearchWordsUrl, params), KeyWordsDto.class,
                listener, errorListener);
        /** 添加标签 **/
        request.setTag(Constants.RequestTag.GetSearchWordsTag);
        /** 添加执行 **/
        IVolley.getRequestQueuemanager().add(request);
    }

    /**
     * 获取搜索页面
     */
    public void requestSearchResult(Map<String, Object> params,
                                    Response.Listener<SeachBooksDto> listener, Response.ErrorListener errorListener) {
        RequestGet<SeachBooksDto> request = new RequestGet<>(returnGetUrl1(
                Constants.ServiceInterFace.GetSearchResultUrl, params), SeachBooksDto.class,
                listener, errorListener);
        /** 添加标签 **/
        request.setTag(Constants.RequestTag.GetSearchResultTag);
        /** 添加执行 **/
        IVolley.getRequestQueuemanager().add(request);
    }

    /**
     * 获取书籍详情
     */
    public void requestBookDetail(Object object,
                                  Response.Listener<BookDetailDto> listener, Response.ErrorListener errorListener) {
        RequestGet<BookDetailDto> request = new RequestGet<>(returnGetUrl(
                Constants.ServiceInterFace.GetBookDetailUrl, object), BookDetailDto.class,
                listener, errorListener);
        /** 添加标签 **/
        request.setTag(Constants.RequestTag.GetBookDetailTag);
        /** 添加执行 **/
        IVolley.getRequestQueuemanager().add(request);
    }

    /**
     * 获取搜索页面
     */
    public void requestBookDetailReview(Map<String, Object> params,
                                        Response.Listener<ReviewDto> listener, Response.ErrorListener errorListener) {
        RequestGet<ReviewDto> request = new RequestGet<>(returnGetUrl1(
                Constants.ServiceInterFace.GetBookDetailReviewUrl, params), ReviewDto.class,
                listener, errorListener);
        /** 添加标签 **/
        request.setTag(Constants.RequestTag.GetBookDetailReviewTag);
        /** 添加执行 **/
        IVolley.getRequestQueuemanager().add(request);
    }

    /**
     * 获取用户详情评论
     */
    public void requestUsrDetailReview(Object object,
                                       Response.Listener<UserReviewDto> listener, Response.ErrorListener errorListener) {
        RequestGet<UserReviewDto> request = new RequestGet<>(returnGetUrl(
                Constants.ServiceInterFace.GetUserDetailReviewUrl, object), UserReviewDto.class,
                listener, errorListener);
        /** 添加标签 **/
        request.setTag(Constants.RequestTag.GetUserDetailReviewTag);
        /** 添加执行 **/
        IVolley.getRequestQueuemanager().add(request);
    }

    /**
     * 获取评论楼层
     */
    public void requestReviewFloor(Map<String, Object> params,
                                   Response.Listener<ReviewFloorDto> listener, Response.ErrorListener errorListener) {
        RequestGet<ReviewFloorDto> request = new RequestGet<>(returnGetUrl1(
                Constants.ServiceInterFace.GetUserDetailReviewUrl, params), ReviewFloorDto.class,
                listener, errorListener);
        /** 添加标签 **/
        request.setTag(Constants.RequestTag.GetReviewFloorTag);
        /** 添加执行 **/
        IVolley.getRequestQueuemanager().add(request);
    }
    // --------------------以上是请求---------------------------------------

    /**
     * 拼接请求
     *
     * @param url
     * @param map
     * @return
     */
    public static String returnGetUrl(String url, Object map) {
        // 设置Get请求方式
        StringBuffer sb = new StringBuffer();
        String key = RequestManager.returnGetPara1(map);
        sb.append(url);
        sb.append(key);
        return sb.toString();
    }

    /**
     * 拼接请求
     *
     * @param url
     * @param
     * @return
     */
    public static String returnGetUrl1(String url, Map<String, Object> params) {
        // 设置Get请求方式
        StringBuffer sb = new StringBuffer();
        sb.append(url);
        Log.e("params", String.valueOf(params.keySet()));
        for (String key : params.keySet()) {

            if (key.equals("idargs")) {
                sb.append("/");
                sb.append(params.get("idargs").toString());
                sb.append("/comment");
            }
        }
        sb.append("?");

        sb.append(returnGetPara(params));
        return sb.toString();
    }

    /**
     * 拼接请求参数
     *
     * @param param
     * @return
     */
    public static String returnGetPara1(Object... param) {
        String key = "";
        for (Object o : param) {
            key += "/" + o;
        }
        return key.replaceFirst("-", "");
    }

    /**
     * 拼接请求参数
     *
     * @param params
     * @return
     */
    private static String returnGetPara(Map<String, Object> params) {
        StringBuffer sb = new StringBuffer();
        for (String key : params.keySet()) {
            if (key.equals("idargs")) {

            } else{
                String value = params.get(key).toString();
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("&");
        }
        }
        String result = "";
        if (sb.length() < 1) {
            result = sb.toString();
        } else {
            result = sb.deleteCharAt(sb.length() - 1).toString();
        }
        return result;
    }

}
