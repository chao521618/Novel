package yueshenginfo.com.mynovel.publics.net.volley;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: RequestGet<br/>
 * Description:  Volley的get请求<br/>
 * <p/>
 * Copyright: Copyright (c) 众远科技<br/>
 * Company: 济南众远信息科技有限公司<br/>
 *
 * @author create 高越 2015年12月15日<br/>
 * @version 1.0
 * @since 1.0
 */
public class RequestGet<T> extends Request<T> {

    /**
     * Charset for request.
     */
    private static final String PROTOCOL_CHARSET = "utf-8";

    /**
     * Content type for request.
     */
    private static final String PROTOCOL_CONTENT_TYPE = String.format(
            "application/json; charset=%s", PROTOCOL_CHARSET);
    /**
     * 监听器
     */
    private final Listener<T> listener;

    /**
     * 解析方式
     */
    private Gson mGson;

    /**
     * 解析的Bean类型
     */
    private Class<T> clazz;

    /**
     * params
     */
    private Map<String, String> params = new HashMap<String, String>();

    /**
     * headers
     */
    private Map<String, String> headers = new HashMap<String, String>();

    /**
     * 初始化的类型(Get请求)
     */
    public RequestGet(String url, Class<T> clazz, Listener<T> listener,
                      ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        Logger.d("【请求的url】 ==> { " + url + " }");
        this.mGson = new Gson();
        this.clazz = clazz;
        this.listener = listener;
    }

    /**
     * RetryPolicy 设置超时时间和重连次数
     */
    @Override
    public RetryPolicy getRetryPolicy() {
        RetryPolicy retryPolicy = new DefaultRetryPolicy(
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        return retryPolicy;
    }

    /**
     * 设置几个必要的参数
     */
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        /** 置字符集为UTF-8,并采用gzip压缩传输 **/
        headers.put("Charset", "UTF-8");
        headers.put("Content-Type", "application/x-javascript");
        // headers.put("Accept-Encoding", "gzip,deflate");
        return headers;
    }

    /**
     * 简单的参数
     */
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    protected void deliverResponse(T t) {
        listener.onResponse(t);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String strObject = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            //log打印插件
            Logger.json(strObject);
            T parsedGSON = mGson.fromJson(strObject, clazz);
            return Response.success(parsedGSON,
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (Exception e) {
            Log.e("error", e.getMessage().toString());
            return Response.error(new ParseError(e));
        }
    }

    @Override
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

}
