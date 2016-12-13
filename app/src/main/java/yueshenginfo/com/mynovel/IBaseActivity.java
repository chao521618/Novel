package yueshenginfo.com.mynovel;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import yueshenginfo.com.mynovel.publics.utils.EmptyUtils;


/**
 * Title: IBaseActivity<br/>
 * Description: Activity基类<br/>
 * Copyright: Copyright (c) 山东悦升<br/>
 * Company: 山东悦升信息技术有限公司<br/>
 * Author: created 李忠峰 2016/6/16<br/>
 * Since: 1.0
 * Version: 1.0
 */
public abstract class IBaseActivity extends FragmentActivity {

    protected Context mContext;

    protected IBaseApplication mApplication;

    //protected KProgressHUD mKProgressHUD;

    /**
     * onCreate
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设定始终保持竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mContext = this;

//        FrescoConfigConstants.init(getResources());// 初始化默认图片（占位图，错误图）
     //   Fresco.initialize(mContext);// 图片缓存初始化配置

        mApplication = IBaseApplication.getInstance();
        mApplication.mScreenManager.pushActivity(this);// 管理Activity
    }

    /**
     * 初始化控件
     */
    public abstract void initViews();

    /**
     * 初始化数据
     */
    public abstract void initDatas();

    /**
     * 根据控件id查找控件
     *
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getViewById(int id) {
        return (T) this.findViewById(id);
    }

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
     * 返回
     *
     * @param v
     */
    public void onBackPressed(View v) {
        onBackPressed();
        // activity切换动画
    }

    /**
     * 返回
     */
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * onDestroy
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 滚动条开始
     */
    public void showProgress() {
        // 滚动条
//        mKProgressHUD = KProgressHUD.create(mContext)
//                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
//                .setLabel("请等待...")
//                .setCancellable(true)
//                .setAnimationSpeed(2)
//                .setDimAmount(0.6f)
//                .show();
   }

    /**
     * 自定义标题的滚动条开始
     */
//    public void showProgress(String title) {
//        // 滚动条
//        mKProgressHUD = KProgressHUD.create(mContext)
//                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
//                .setLabel(title)
//                .setCancellable(true)
//                .setAnimationSpeed(2)
//                .setDimAmount(0.6f)
//                .show();
//    }

    /**
     * 滚动条关闭
     */
    public void dismissProgress() {
//        if (mKProgressHUD != null) {
//            mKProgressHUD.dismiss();
//            mKProgressHUD = null;
//        }
    }
}