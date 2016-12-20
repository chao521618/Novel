package yueshenginfo.com.mynovel.publics.common;

import android.content.Context;

import yueshenginfo.com.mynovel.publics.utils.SharePreferenceUtils;


/**
 * Description: 从SharedPreferences获取用户信息<br/>
 * <p/>
 *
 * @version 1.0
 * @since 1.0
 */
public class MessageInfo {

    private static SharePreferenceUtils mSharePreferenceUtils;

    private static void initSharePerference(Context context) {
        if (mSharePreferenceUtils == null) {
            mSharePreferenceUtils = new SharePreferenceUtils(context,
                    Constants.MessageInfo);
        }
    }


    /**
     * 历史搜索
     *
     * @param context
     * @return
     */
    public static void setHistorySearch(Context context, String str) {
        initSharePerference(context);
        mSharePreferenceUtils.put(Constants.HistorySearch, str);
    }

    /**
     * 历史搜索
     *
     * @param context
     * @return
     */
    public static String getHistorySearch(Context context) {
        initSharePerference(context);
        String str = (String) mSharePreferenceUtils.get(Constants.HistorySearch,
                "");
        return str;
    }

    /**
     * 清理数据
     *
     * @param context
     */
    public static void clean(Context context) {
        initSharePerference(context);
        mSharePreferenceUtils.clear();
    }

}