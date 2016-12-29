package yueshenginfo.com.mynovel.module.home.read;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huchao on 2016/12/6.
 * Email 1064224874@qq.com
 */
public class BookContentCustomView extends TextView {

    public BookContentCustomView(Context context) {
        super(context);
    }

    public BookContentCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BookContentCustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    /**
     * 分页。
     *
     * @param listener
     */
    public void onPage(OnReaderPageListener listener) {
        Layout layout = getLayout();
        if (layout == null) return;

        int length = length();
        int height = getHeight() - getPaddingTop() - getPaddingBottom();

        // 总行数
        int lineCount = getLineCount();

        // 可见的最后一行,即：一页可显示多少行.
        int lastLine = layout.getLineForVertical(height);
        int pagesCount = (int) Math.ceil(lineCount / (double) lastLine);

        int[] offsets = new int[pagesCount];
        int end;
        for (int i = 0; i < pagesCount; i++) {
            end = layout.getLineStart(i * lastLine);
            if (end > length) end = length;
            offsets[i] = end;
        }
        List<String> pages = getPages(offsets, getText().toString());
        if (listener != null) listener.onSuccess(pages);
    }

    private List<String> getPages(int[] offsets, String text) {
        List<String> pages = new ArrayList<String>();
        for (int i = 0; i < offsets.length; i++) {
            if (i < offsets.length - 1) {
                pages.add(text.substring(offsets[i], offsets[i + 1]));
            } else {
                pages.add(text.substring(offsets[i], text.length()));
            }
        }
        return pages;
    }

}
