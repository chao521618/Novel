package yueshenginfo.com.mynovel.publics.utils;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * 
 * Title: EmptyUtils<br/>
 * Description: 判空工具类<br/>
 * 
 * Copyright: Copyright (c) 众远科技<br/>
 * Company: 青岛美德威文化传播有限公司<br/>
 * 
 * @author create 高越 2015年10月15日<br/>
 * @since 1.0
 * @version 1.0
 */
public class EmptyUtils {
	public static boolean isNull(Object obj) {
		return obj == null ? true : false;
	}

	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

	public static boolean isNotEmpty(Object obj) {
		if (isNull(obj)) {
			return false;
		}
		if (obj.getClass().isArray()) {
			return Array.getLength(obj) > 0 ? true : false;
		}
		if (obj instanceof Collection) {
			return ((Collection<?>) obj).size() > 0 ? true : false;
		}
		if (obj instanceof Map) {
			return ((Map<?, ?>) obj).size() > 0 ? true : false;
		}
		if (obj instanceof String) {
			return obj.toString().trim().length() > 0 ? true : false;
		}
		if (obj instanceof File) {
			return ((File) obj).exists();
		}
		return true;
	}

	public static boolean isEmpty(Object obj) {
		return !isNotEmpty(obj);
	}

}