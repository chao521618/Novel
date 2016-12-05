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
        public static String GetBookContentUrl = BaseUrl+"/mix-atoc";

    }

    /**
     * @description Request的Tag管理
     */
    public static class RequestTag {
        public static final int GetBookContentTag = 1001;
    }
}
