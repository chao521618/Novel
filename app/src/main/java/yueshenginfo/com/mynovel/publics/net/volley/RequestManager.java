package yueshenginfo.com.mynovel.publics.net.volley;

import com.android.volley.Response;

import java.util.Map;

import yueshenginfo.com.mynovel.module.home.dto.BookContentDto;
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
     * 获取书籍内容
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

    // --------------------以上是请求---------------------------------------

    /**
     * 拼接请求
     *
     * @param url
     * @param map
     * @return
     */
    public static String returnGetUrl(String url,Object map) {
        // 设置Get请求方式
        StringBuffer sb = new StringBuffer();
        String key = RequestManager.returnGetPara1(map);
        sb.append(url);
        sb.append(key);
        return sb.toString();
    }

    /**
     * 拼接请求参数
     * @param param
     * @return
     */
    public static String returnGetPara1(Object... param) {
        String key = "";
        for (Object o : param) {
            key += "/" + o;
        }
        return key.replaceFirst("-","");
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
            String value = params.get(key).toString();
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("&");
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
