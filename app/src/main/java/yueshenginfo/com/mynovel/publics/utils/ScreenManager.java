package yueshenginfo.com.mynovel.publics.utils;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * @TODO activity 管理
 * 
 */
public class ScreenManager {

	/**
	 * Activity栈
	 */
	private static List<Activity> activityStack;
	/**
	 * 单例模式
	 */
	private static ScreenManager instance;

	private ScreenManager() {
	}

	public static ScreenManager getScreenManager() {
		if (instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}

	/**
	 * 注销栈中指定Activity
	 * 
	 * @param activity
	 */
	public void popActivity(Activity activity) {
		if (activity != null) {
			activity.finish();
		}
	}

	/**
	 * 将Activity压入栈中
	 * 
	 * @param activity
	 */
	public void pushActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new LinkedList<Activity>();
		}
		if (activity != null) {
			activityStack.add(activity);
		}
	}

	/**
	 * 启动指定Activity
	 * 
	 * @param cls
	 */
	public void startActivity(Class<?> cls) {
		for (int i = 0; i < activityStack.size(); i++) {
			if (activityStack.get(i).getClass().equals(cls)) {
				activityStack.set(0, activityStack.get(i));
			}
		}
	}

	/**
	 * 清除全部
	 */
	public void finishAllActivity() {
		try {
			for (Activity activity : activityStack) {
				if (activity != null) {
					popActivity(activity);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
	
}
