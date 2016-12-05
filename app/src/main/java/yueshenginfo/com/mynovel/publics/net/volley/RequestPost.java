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

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Title: RequestPost<br/>
 * Description: Volley的Post请求<br/>
 * 
 * Copyright: Copyright (c) 众远科技<br/>
 * Company: 济南众远信息科技有限公司<br/>
 * 
 * @author create 高越 2015年12月15日<br/>
 * @since 1.0
 * @version 1.0
 */
public class RequestPost<T> extends Request<T> {

	/**
	 * params
	 */
	private Map<String, String> params = new HashMap<String, String>();

	/**
	 * 解析方式
	 */
	private Gson mGson;

	/**
	 * 解析的Bean类型
	 */
	private Class<T> clazz;

	/**
	 * 监听器
	 */
	private final Listener<T> listener;

	/**
	 * 初始化的类型带Param
	 */
	public RequestPost(String url, Map<String, String> params, Class<T> clazz,
					   Listener<T> listener, ErrorListener errorListener) {
		super(Method.POST, url, errorListener);
		this.clazz = clazz;
		this.mGson = new Gson();
		this.listener = listener;
		this.params = params;
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

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Charset", "UTF-8");
		headers.put("Content-Type", "application/x-javascript");
		return headers;
	}

	/**
	 * 简单的参数
	 */
	@Override
	protected Map<String, String> getParams() throws AuthFailureError {
		return params;
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
			T parsedGSON = mGson.fromJson(strObject, clazz);
			return Response.success(parsedGSON,
					HttpHeaderParser.parseCacheHeaders(response));
		} catch (Exception e) {
			Log.e("error", e.getMessage().toString());
			return Response.error(new ParseError(e));
		}
	}
	
}
