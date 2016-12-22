package yueshenginfo.com.mynovel.publics.utils;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;

/**
 * Title: CountDownTimerUtils<br/>
 * Description: 按钮倒计时<br/>
 * Copyright: Copyright (c) 山东悦升<br/>
 * Company: 山东悦升信息技术有限公司<br/>
 * Author: created 李忠峰 2016/7/6 11:08<br/>
 * Since: 1.0
 * Version: 1.0
 *
 * 用法：
 * CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(mButton, 60000, 1000);
 * mCountDownTimerUtils.start();
 */
public class CountDownTimerUtils extends CountDownTimer {
    private Button mButton;

    public CountDownTimerUtils(Button mButton, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.mButton = mButton;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mButton.setClickable(false); //设置不可点击
        mButton.setEnabled(false);
        mButton.setText(millisUntilFinished / 1000 + " 秒后重发");  //设置倒计时时间

        /**
         * 超链接 URLSpan
         * 文字背景颜色 BackgroundColorSpan
         * 文字颜色 ForegroundColorSpan
         * 字体大小 AbsoluteSizeSpan
         * 粗体、斜体 StyleSpan
         * 删除线 StrikethroughSpan
         * 下划线 UnderlineSpan
         * 图片 ImageSpan
         * http://blog.csdn.net/ah200614435/article/details/7914459
         */
        SpannableString spannableString = new SpannableString(mButton.getText().toString());  //获取按钮上的文字
        ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);
        /**
         * public void setSpan(Object what, int start, int end, int flags) {
         * 主要是start跟end，start是起始位置,无论中英文，都算一个。
         * 从0开始计算起。end是结束位置，所以处理的文字，包含开始位置，但不包含结束位置。
         */
        spannableString.setSpan(span, 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//将倒计时的时间设置为红色
        mButton.setText(spannableString);
    }

    @Override
    public void onFinish() {
        mButton.setText("重新获取");
        mButton.setClickable(true);//重新获得点击
        mButton.setEnabled(true);
    }
}