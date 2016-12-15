package yueshenginfo.com.mynovel;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaopiz.kprogresshud.KProgressHUD;

import yueshenginfo.com.mynovel.publics.utils.EmptyUtils;


/**
 * Title: IBaseFragment<br/>
 * Description: Fragment基类<br/>
 * Copyright: Copyright (c) 山东悦升<br/>
 * Company: 山东悦升信息技术有限公司<br/>
 * Author: created 李忠峰 2016/5/27<br/>
 * Since: 1.0
 * Version: 1.0
 */
public abstract class IBaseFragment extends Fragment {

    protected Context mContext;
    private View rootView;

    protected KProgressHUD mKProgressHUD;

    /**
     * onCreate
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();
    }

    /**
     * onCreateView
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = createView(inflater, container);
//            ButterKnife.bind(this, rootView);
        }
        return rootView;
    }

    /**
     * onDestroyView
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup) rootView.getParent()).removeView(rootView);
//        ButterKnife.unbind(this);
    }

    /**
     * 根据控件id查找控件
     *
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getViewById(int id) {
        return (T) rootView.findViewById(id);
    }

    /**
     * 子类实现创建View操作
     *
     * @param inflater
     * @param container
     * @return
     */
    public abstract View createView(LayoutInflater inflater, ViewGroup container);

    /**
     * 子类初始化View操作
     */
    public abstract void initViews();

    /**
     * 子类实现初始化数据操作
     */
    public abstract void initDatas();

    /**
     * 设置title
     */
    public void setTitle(String title) {
        TextView titleView = getViewById(R.id.titlename_txt);
        if (EmptyUtils.isNotEmpty(title)) {
            titleView.setText(title);
        }
    }

    /**
     * 方法功能
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    /**
     * 方法功能
     */
    public void showProgress() {
        // 滚动条
        mKProgressHUD = KProgressHUD.create(mContext)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("请等待...")
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.6f)
                .show();
   }

    /**
     * 自定义标题的滚动条开始
     */public void showProgress(String title) {
//        // 滚动条
//        mKProgressHUD = KProgressHUD.create(mContext)
//                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
//                .setLabel(title)
//                .setCancellable(true)
//                .setAnimationSpeed(2)
//                .setDimAmount(0.6f)
//                .show();
    }

    /**
     * 方法功能
     */
    public void dismissProgress() {
        if (mKProgressHUD != null) {
            mKProgressHUD.dismiss();
            mKProgressHUD = null;
        }
    }
//
}
