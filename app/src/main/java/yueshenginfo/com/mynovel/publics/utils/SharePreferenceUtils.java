package yueshenginfo.com.mynovel.publics.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Title: SharePreferenceUtils<br/>
 * Description: sharedPrefrence 工具类<br/>
 * 
 * Copyright: Copyright (c) 众远科技<br/>
 * Company: 济南众远信息科技有限公司<br/>
 * 
 * @author create 高越 2015年10月13日<br/>
 * @since 1.0
 * @version 1.0
 */
public class SharePreferenceUtils {

    private SharedPreferences mySp;
    private Editor mEditor;

    // public static String spName = "RemindPrefrence";

    /**
     * 构造方法。
     * 
     * @param context
     * @param spName
     *            键值表名称。
     * @param mode
     *            打开的模式。值为Context.MODE_APPEND, Context.MODE_PRIVATE, Context.WORLD_READABLE,
     *            Context.WORLD_WRITEABLE.
     */

    public SharePreferenceUtils(Context mCtx, String spName) {
        mySp = mCtx.getSharedPreferences(spName, Context.MODE_PRIVATE);
        mEditor = mySp.edit();
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     * 
     * @param context
     * @param key
     * @param defaultObject
     * @return
     */
    @SuppressWarnings("unchecked")
    public Object get(String key, Object defaultObject) {
        if (defaultObject instanceof String) {
            return mySp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return mySp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return mySp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return mySp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return mySp.getLong(key, (Long) defaultObject);
        } else if (defaultObject instanceof Set) {
            return mySp.getStringSet(key, (Set<String>) defaultObject);
        }
        return null;
    }

    /**
     * 获取所有键值对。
     * 
     * @return 获取到的所有键值对。
     */
    public Map<String, ?> getAll() {
        return mySp.getAll();
    }

    /**
     * 设置一个键值对，它将在{@linkplain #commit()}被调用时保存。<br/>
     * 注意：当保存的value不是boolean, byte(会被转换成int保存),int, long, float, String等类型时将调用它的toString()方法进行值的保存。
     * 
     * @param key
     *            键名称。
     * @param value
     *            值。
     * @return 引用的KV对象。
     */
    @SuppressWarnings("unchecked")
    public SharePreferenceUtils put(String key, Object value) {
        if (value instanceof Boolean) {
            mEditor.putBoolean(key, (Boolean) value).commit();
        } else if (value instanceof Integer || value instanceof Byte) {
            mEditor.putInt(key, (Integer) value).commit();
        } else if (value instanceof Long) {
            mEditor.putLong(key, (Long) value).commit();
        } else if (value instanceof Float) {
            mEditor.putFloat(key, (Float) value).commit();
        } else if (value instanceof String) {
            mEditor.putString(key, (String) value).commit();
        } else if (value instanceof Collection) {
            mEditor.putStringSet(key, (Set<String>) value).commit();
        }
        return this;
    }

    /**
     * 移除键值对。
     * 
     * @param key
     *            要移除的键名称。
     * @return 引用的KV对象。
     */
    public SharePreferenceUtils remove(String key) {
        mEditor.remove(key).commit();
        return this;
    }

    /**
     * 清除所有键值对。
     * 
     * @return 引用的KV对象。
     */
    public SharePreferenceUtils clear() {
        mEditor.clear().commit();
        return this;
    }

    /**
     * 是否包含某个键。
     * 
     * @param key
     *            查询的键名称。
     * @return 当且仅当包含该键时返回true, 否则返回false.
     */
    public boolean contains(String key) {
        return mySp.contains(key);
    }

    /**
     * 返回是否提交成功。
     * 
     * @return 当且仅当提交成功时返回true, 否则返回false.
     */
    public boolean commit() {
        return mEditor.commit();
    }

}
