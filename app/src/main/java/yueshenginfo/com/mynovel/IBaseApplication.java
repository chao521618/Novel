package yueshenginfo.com.mynovel;

import android.app.Application;
import android.content.Context;

import yueshenginfo.com.mynovel.publics.utils.ScreenManager;


/**
 * Title: IBaseApplication<br/>
 * Description: 自定义Application<br/>
 * Copyright: Copyright (c) 山东悦升<br/>
 * Company: 山东悦升信息技术有限公司<br/>
 * Author: created 李忠峰 2016/6/16<br/>
 * Since: 1.0
 * Version: 1.0
 */
public class IBaseApplication extends Application {

    @SuppressWarnings("unused")
    private Context mContext;

    /**
     * 单例
     */
    private static IBaseApplication mBaseApplication;

    /**
     * 管理所有的activity
     */
    public ScreenManager mScreenManager;

    // 单例的BaseApplication
    public static IBaseApplication getInstance() {
        if (mBaseApplication == null) {
            mBaseApplication = new IBaseApplication();
        }
        return mBaseApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseApplication = this;
        mContext = this;
        // 管理所有activity
        mScreenManager = ScreenManager.getScreenManager();
    }
}