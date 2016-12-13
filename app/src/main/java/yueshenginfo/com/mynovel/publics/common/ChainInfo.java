//package yueshenginfo.com.mynovel.publics.common;
//
//import android.content.Context;
//
//import com.yueshenginfo.smejn.publics.utils.SharePreferenceUtils;
//
//
///**
// * Title: UserInfo<br/>
// * Description: 从SharedPreferences获取用户信息<br/>
// * <p/>
// * Copyright: Copyright (c) 众远科技<br/>
// * Company: 济南众远信息科技有限公司<br/>
// *
// * @author create 高越 2015年11月2日<br/>
// * @version 1.0
// * @since 1.0
// */
//public class ChainInfo {
//
//    private static SharePreferenceUtils mSharePreferenceUtils;
//
//    private static void initSharePerference(Context context) {
//        if (mSharePreferenceUtils == null) {
//            mSharePreferenceUtils = new SharePreferenceUtils(context,
//                    Constants.CHAIN_INCO);
//        }
//    }
//
//    /**
//     * logo地址
//     *
//     * @param context
//     * @return
//     */
//    public static void setLogoPath(Context context, String path) {
//        initSharePerference(context);
//        mSharePreferenceUtils.put(Constants.LOGO_PATH, path);
//    }
//
//    /**
//     * logo地址
//     *
//     * @param context
//     * @return
//     */
//    public static String getLogoPath(Context context) {
//        initSharePerference(context);
//        String id = (String) mSharePreferenceUtils.get(Constants.LOGO_PATH,
//                "");
//        return id;
//    }
//
//    /**
//     * 项目名称
//     *
//     * @param context
//     * @return
//     */
//    public static void setProjectName(Context context, String str) {
//        initSharePerference(context);
//        mSharePreferenceUtils.put(Constants.PROJECT_NAME, str);
//    }
//
//    /**
//     * 项目名称
//     *
//     * @param context
//     * @return
//     */
//    public static String getProjectName(Context context) {
//        initSharePerference(context);
//        String str = (String) mSharePreferenceUtils.get(Constants.PROJECT_NAME,
//                "");
//        return str;
//    }
//
//    /**
//     * 简介
//     *
//     * @param context
//     * @return
//     */
//    public static void setProjectShortDesc(Context context, String str) {
//        initSharePerference(context);
//        mSharePreferenceUtils.put(Constants.PROJECT_SHORT_DESC, str);
//    }
//
//    /**
//     * 简介
//     *
//     * @param context
//     * @return
//     */
//    public static String getProjectShortDesc(Context context) {
//        initSharePerference(context);
//        String str = (String) mSharePreferenceUtils.get(Constants.PROJECT_SHORT_DESC,
//                "");
//        return str;
//    }
//
//    /**
//     * 详情
//     *
//     * @param context
//     * @return
//     */
//    public static void setProjectDesc(Context context, String str) {
//        initSharePerference(context);
//        mSharePreferenceUtils.put(Constants.PROJECT_DESC, str);
//    }
//
//    /**
//     * 详情
//     *
//     * @param context
//     * @return
//     */
//    public static String getProjectDesc(Context context) {
//        initSharePerference(context);
//        String str = (String) mSharePreferenceUtils.get(Constants.PROJECT_DESC,
//                "");
//        return str;
//    }
//
//    /**
//     * 行业名称
//     *
//     * @param context
//     * @return
//     */
//    public static void setIndustryTitle(Context context, String str) {
//        initSharePerference(context);
//        mSharePreferenceUtils.put(Constants.PROJECT_INDUSTRY_TITLE, str);
//    }
//
//    /**
//     * 行业名称
//     *
//     * @param context
//     * @return
//     */
//    public static String getIndustryTitle(Context context) {
//        initSharePerference(context);
//        String str = (String) mSharePreferenceUtils.get(Constants.PROJECT_INDUSTRY_TITLE,
//                "");
//        return str;
//    }
//
//    /**
//     * 行业Id
//     *
//     * @param context
//     * @return
//     */
//    public static void setIndustryId(Context context, String str) {
//        initSharePerference(context);
//        mSharePreferenceUtils.put(Constants.PROJECT_INDUSTRY_ID, str);
//    }
//
//    /**
//     * 行业Id
//     *
//     * @param context
//     * @return
//     */
//    public static String getIndustryId(Context context) {
//        initSharePerference(context);
//        String str = (String) mSharePreferenceUtils.get(Constants.PROJECT_INDUSTRY_ID,
//                "");
//        return str;
//    }
//
//    /**
//     * 设置标签
//     *
//     * @param context
//     * @return
//     */
//    public static void setTagSelectStr(Context context, String str) {
//        initSharePerference(context);
//        mSharePreferenceUtils.put(Constants.IS_SELECT_TAGS, str);
//    }
//
//    /**
//     * 标签
//     *
//     * @param context
//     * @return
//     */
//    public static String getTagSelectStr(Context context) {
//        initSharePerference(context);
//        String str = (String) mSharePreferenceUtils.get(Constants.IS_SELECT_TAGS,
//                "");
//        return str;
//    }
//
//    /**
//     * 是否设置图片
//     *
//     * @param context
//     * @return
//     */
//    public static void setIsSelectImg(Context context, String str) {
//        initSharePerference(context);
//        mSharePreferenceUtils.put(Constants.IS_SELECT_IMGS, str);
//    }
//
//    /**
//     * 是否设置图片
//     *
//     * @param context
//     * @return
//     */
//    public static String getIsSelectImg(Context context) {
//        initSharePerference(context);
//        String str = (String) mSharePreferenceUtils.get(Constants.IS_SELECT_IMGS,
//                "");
//        return str;
//    }
//
//    /**
//     * 是否设置优势
//     *
//     * @param context
//     * @return
//     */
//    public static void setIsSelectAdvantage(Context context, String str) {
//        initSharePerference(context);
//        mSharePreferenceUtils.put(Constants.IS_INPUT_ADVANTAGE, str);
//    }
//
//    /**
//     * 是否设置优势
//     *
//     * @param context
//     * @return
//     */
//    public static String getIsSelectAdvantage(Context context) {
//        initSharePerference(context);
//        String str = (String) mSharePreferenceUtils.get(Constants.IS_INPUT_ADVANTAGE,
//                "");
//        return str;
//    }
//
//    /**
//     * 是否设置加盟方式
//     *
//     * @param context
//     * @return
//     */
//    public static void setIsSelectJoinMethod(Context context, String str) {
//        initSharePerference(context);
//        mSharePreferenceUtils.put(Constants.IS_INPUT_JION_METHOD, str);
//    }
//
//    /**
//     * 是否设置加盟方式
//     *
//     * @param context
//     * @return
//     */
//    public static String getIsSelectJoinMethod(Context context) {
//        initSharePerference(context);
//        String str = (String) mSharePreferenceUtils.get(Constants.IS_INPUT_JION_METHOD,
//                "");
//        return str;
//    }
//
//    /**
//     * 清理数据
//     *
//     * @param context
//     */
//    public static void clean(Context context) {
//        initSharePerference(context);
//        mSharePreferenceUtils.clear();
//    }
//
//
//}