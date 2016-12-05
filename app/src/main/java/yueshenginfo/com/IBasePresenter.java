package yueshenginfo.com;

import java.lang.ref.WeakReference;

/**
 * Title: IBasePresenter<br/>
 * Description: 业务逻辑与view交互基类<br/>
 * Copyright: Copyright (c) 山东悦升<br/>
 * Company: 山东悦升信息技术有限公司<br/>
 * Author: created 李忠峰 2016/6/28<br/>
 * Since: 1.0
 * Version: 1.0
 */
public abstract class IBasePresenter<T extends IBaseView> {

	private WeakReference<T> weakReference;
	
	public abstract void initialized();

	public IBasePresenter(T t) {
        if (isViewEmpty(t)) {
            throw new NullPointerException("view is null, check it");
        }
        this.weakReference = new WeakReference<T>(t);
        initialized();
    }

	public T getView() {
		T t = weakReference.get();
		return t;
	}

	public boolean isViewEmpty(T t) {
		if (t == null) {
			return true;
		}
		return false;
	}

}
