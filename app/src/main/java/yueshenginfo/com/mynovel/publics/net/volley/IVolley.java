package yueshenginfo.com.mynovel.publics.net.volley;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.squareup.okhttp.OkHttpClient;

import yueshenginfo.com.mynovel.IBaseApplication;
import yueshenginfo.com.mynovel.publics.net.okhttp.OkHttpStack;

/**
 * Title: IVolley<br/>
 * Description: volley管理器<br/>
 * 
 * Copyright: Copyright (c) 众远科技<br/>
 * Company: 济南众远信息科技有限公司<br/>
 * 
 * @author create 高越 2015年12月9日<br/>
 * @since 1.0
 * @version 1.0
 */
public class IVolley {

	/**
	 * 全局定义的RequestQueue
	 */
	private static RequestQueue mRequestQueue;

	// Vollery 管理器 单例
	public static RequestQueue getRequestQueuemanager() {
        
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(
					IBaseApplication.getInstance(), new OkHttpStack(new OkHttpClient()));
		}
		return mRequestQueue;
	}

}
