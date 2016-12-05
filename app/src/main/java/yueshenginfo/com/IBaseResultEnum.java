package yueshenginfo.com;

/**
 * Title: IBaseResultEnum<br/>
 * Description: 业务系统中用到的表的信息属性的枚举<br/>
 * Copyright: Copyright (c) 山东悦升<br/>
 * Company: 山东悦升信息技术有限公司<br/>
 * Author: created 李忠峰 2016/6/28<br/>
 * Since: 1.0
 * Version: 1.0
 */
public enum IBaseResultEnum {

	// 结果
	R_0000("0000", "成功"), R_0001("0001", "失败"), R_0002("0002", "服务器错误，请重试"), R_0003(
			"0003", "超时"), R_0004("0004", "用户验证不存在"), R_0005("0005", "用户受限制"), R_0006(
			"0006", "签名验证失败"), R_0007("0007", "token验证失败"), R_0011("0011",
			"验证码错误或已失效"), R_0012("0012", "此手机号已申请客户清理,请勿重新申请"), R_0021("0021",
			"未知错误，操作失败");

	/**
	 * 结果
	 */
	private String code;

	/**
	 * 错误信息
	 */
	private String msg;

	/**
	 * 构造函数
	 * 
	 * @param msg
	 *            描述
	 * @param code
	 *            值
	 */
	private IBaseResultEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getResult() {
		return code;
	}

	public String getErrorInfo() {
		return msg;
	}

}
