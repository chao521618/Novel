package yueshenginfo.com.mynovel.publics.utils;

import java.util.UUID;

/**
 * Title: UUIDUtil<br/>
 * Description: UUID工具类<br/>
 * Copyright: Copyright (c) 山东悦升<br/>
 * Company: 山东悦升信息技术有限公司<br/>
 * Author: created 李忠峰 2016/6/28<br/>
 * Since: 1.0
 * Version: 1.0
 */
public class UUIDUtil {

	/**
	 * 获取uuid（32位）
	 * 
	 * @description
	 * 
	 * @return uuid
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
