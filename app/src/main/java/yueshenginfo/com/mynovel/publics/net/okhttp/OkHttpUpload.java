package yueshenginfo.com.mynovel.publics.net.okhttp;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import yueshenginfo.com.mynovel.publics.utils.UUIDUtil;

/**
 * Title: OkHttpUpload<br/>
 * Description: OkHttp数据+文件传输<br/>
 * Copyright: Copyright (c) 山东悦升<br/>
 * Company: 山东悦升信息技术有限公司<br/>
 * Author: created 李忠峰 2016/6/28<br/>
 * Since: 1.0
 * Version: 1.0
 */
public class OkHttpUpload {

	// 参数类型
	private static final MediaType MEDIA_TYPE_PNG = MediaType
			.parse("application/octet-stream");
	// 创建OkHttpClient实例
	private final OkHttpClient client = new OkHttpClient();
	// 创建builder
	private MultipartBuilder builder = new MultipartBuilder()
			.type(MultipartBuilder.FORM);

	public OkHttpUpload() {
		setTimeOut();
	}

	/**
	 *
	 * 方法功能
	 *
	 * @param url
	 *            url地址
	 * @param imagePaths
	 *            图片路径
	 * @param params
	 *            参数
	 * @param callback
	 *            回调结果
	 */
	public void okHttpUpload(String url, List<String> imagePaths,
			Map<String, Object> params, Callback callback) {
		// 遍历map中所有参数到builder
		for (String key : params.keySet()) {
			builder.addFormDataPart(key, params.get(key).toString());
		}

		// 遍历paths中所有图片绝对路径到builder，并约定key如“upload”作为后台接受多张图片的key
		for (String imagePath : imagePaths) {
			File file = new File(imagePath);
			builder.addFormDataPart(UUIDUtil.getUUID(), file.getName(),
					RequestBody.create(MEDIA_TYPE_PNG, file));
		}

		// 构建请求体
		RequestBody requestBody = builder.build();

		// 构建请求
		Request request = new Request.Builder().url(url)// 地址
				.post(requestBody)// 添加请求体
				.build();

		// 发送异步请求，同步会报错，Android4.0以后禁止在主线程中进行耗时操作
		client.newCall(request).enqueue(callback);
	}

	private void setTimeOut() {
        client.setConnectTimeout(1000, TimeUnit.MINUTES);
        client.setReadTimeout(1000, TimeUnit.MINUTES);
        client.setWriteTimeout(1000, TimeUnit.MINUTES);
    }

	public void close() {
		client.clone();
	}
}
