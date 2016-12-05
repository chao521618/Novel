package yueshenginfo.com;


import yueshenginfo.com.mynovel.publics.net.volley.RequestManager;
import yueshenginfo.com.mynovel.publics.utils.EmptyUtils;

/**
 * Title: IBaseModel<br/>
 * Description: Model 基类<br/>
 * Copyright: Copyright (c) 山东悦升<br/>
 * Company: 山东悦升信息技术有限公司<br/>
 * Author: created 李忠峰 2016/6/28<br/>
 * Since: 1.0
 * Version: 1.0
 */
public class IBaseModel {

	/**
	 * 请求管理器
	 */
	public RequestManager mRequestManager = RequestManager.getInstance();

	/**
	 *
	 * 判断返回数据是否合法
	 *
	 * @param dto
	 * @return
	 */
	public boolean isSuccess(IBaseDto dto) {
		if (EmptyUtils.isNotEmpty(dto)
				&& dto.getCode().equals(IBaseResultEnum.R_0000.getResult())) {
			return true;
		}
		return false;
	}

}
