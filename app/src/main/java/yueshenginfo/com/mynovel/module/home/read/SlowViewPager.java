package yueshenginfo.com.mynovel.module.home.read;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

import java.lang.reflect.Field;

/**
 * Created by huchao on 2016/12/27.
 * Email 1064224874@qq.com
 */
public class SlowViewPager extends ViewPager  {

    private SlowScroller mScroller;

    public SlowViewPager(Context context) {
        super(context);
        init();
    }

    public SlowViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        try {
            Class<?> viewpager = ViewPager.class;
            Field scroller = viewpager.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            Field interpolator = viewpager.getDeclaredField("sInterpolator");
            interpolator.setAccessible(true);
            mScroller = new SlowScroller(getContext(), (Interpolator) interpolator.get(null));
            scroller.set(this, mScroller);
        } catch (Exception e) {
        }
    }
}
