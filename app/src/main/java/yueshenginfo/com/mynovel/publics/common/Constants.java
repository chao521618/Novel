package yueshenginfo.com.mynovel.publics.common;

/**
 * Created by huchao on 2016/12/5.
 * Email 1064224874@qq.com
 */

public class Constants {
    /**
     *
     */
    public static class ServiceInterFace {
        public static String BaseUrl = "http://api.zhuishushenqi.com";
        public static final String IMG_BASE_URL = "http://statics.zhuishushenqi.com";

        public static String GetBookChapterUrl = BaseUrl+"/mix-atoc";
        public static String GetBookContentUrl = "http://chapter2.zhuishushenqi.com/chapter";
        public static String GetBooksCategoryUrl = BaseUrl+"/cats/lv2";
        public static String GetBooksMoreUrl = BaseUrl+"/book/by-categories";
    }

    /**
     * @description Request的Tag管理
     */
    public static class RequestTag {
        public static final int GetBookChapterTag = 1001;
        public static final int GetBookContentTag = 1002;
        public static final int GetBooksCategoryTag = 1003;
        public static final int GetBooksMoreTag = 1004;
    }
}
