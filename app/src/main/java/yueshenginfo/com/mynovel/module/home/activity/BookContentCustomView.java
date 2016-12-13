package yueshenginfo.com.mynovel.module.home.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;

import yueshenginfo.com.mynovel.publics.utils.EmptyUtils;

/**
 * Created by huchao on 2016/12/6.
 * Email 1064224874@qq.com
 */
public class BookContentCustomView extends TextView {

    private String mContent = "Hello World";
    private Paint mPaint;
    /**
     * 字体大小
     */
    private int mFontSize;
    /**
     * 行间距
     **/
    private int mLineSpace;
    /**
     * 间距
     */
    private int marginHeight, marginWidth;

    public BookContentCustomView(Context context, String mContent) {
        super(context);
        this.mContent = mContent;
        marginHeight=50;
        mPaint = new Paint();
        mFontSize = 30;
        mPaint.setTextSize(mFontSize);
        mLineSpace = mFontSize / 5 * 2;
        mPaint.setColor(Color.BLACK);
    }

    public BookContentCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BookContentCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onDraw(Canvas canvas) {
        Paint.FontMetrics fm = mPaint.getFontMetrics();
        float baseline = fm.descent - fm.ascent;
        float x = 0;
        float y = baseline+marginHeight; //由于系统基于字体的底部来绘制文本，所有需要加上字体的高度。
        String txt = mContent;
        String txt1 = "早些年，因为《怀玉公主》的剧情、人设和《还珠格格》很类似，两部剧以及女主角难免被拿来比较。对此，性格直快的郑家榆曾称自己根本不把赵薇放在眼里，她走红是因为运气，琼瑶把剧本写得太好，如果自己来演肯定会比赵薇更红。";
        //文本自动换行
        String[] texts = autoSplit(txt1, mPaint, getWidth() - 15);
        Log.e("mContent的内容", String.valueOf(Arrays.asList(texts)));
        for (String text : texts) {
            if (EmptyUtils.isEmpty(text)) {
                Log.e("============》", "对象为空！！！！！！！！！！！！！！！！！");
            } else {
                canvas.drawText(text, 15, y, mPaint);  //坐标以控件左上角为原点
            }
            y += baseline + fm.leading; //添加字体行间距
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 自动分割文本
     *
     * @param content 需要分割的文本
     * @param p       画笔，用来根据字体测量文本的宽度
     * @param width   最大的可显示像素（一般为控件的宽度）
     * @return 一个字符串数组，保存每行的文本
     */
    private String[] autoSplit(String content, Paint p, float width) {
        int length = content.length();
        float textWidth = p.measureText(content);
        if (textWidth <= width) {
            return new String[]{content};
        }

        int start = 0, end = 1, i = 0;
        int lines = (int) Math.ceil(textWidth / width);//计算行数
        String[] lineTexts = new String[lines];
        while (start < length) {
            if (p.measureText(content, start, end) > width) {//文本宽度超出控件宽度时
                lineTexts[i++] = (String) content.subSequence(start, end);
                start = end;
            }
            if (end == length) {//不足一行的文本
                lineTexts[i] = (String) content.subSequence(start, end);
                break;
            }
            end += 1;
        }
        return lineTexts;
    }

}
