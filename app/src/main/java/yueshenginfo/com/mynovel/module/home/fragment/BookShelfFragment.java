package yueshenginfo.com.mynovel.module.home.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dalong.library.listener.OnItemSelectedListener;
import com.dalong.library.view.LoopRotarySwitchView;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.adapter.BookShelfAdapter;
import yueshenginfo.com.mynovel.publics.common.DataProvider;
import yueshenginfo.com.mynovel.publics.utils.Utils;

/**
 * Created by huchao on 2016/11/30.
 * Email 1064224874@qq.com
 */
public class BookShelfFragment extends IBaseFragment {
    private ImageView mImageView;
    private LoopRotarySwitchView mLoopRotarySwitchView;
    private FrameLayout mFrameLayout;
    private RecyclerView mRecyclerView;
    private BookShelfAdapter mBookShelfAdapter;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.bookshelf_fragment_layout, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mImageView = getViewById(R.id.image);
        mLoopRotarySwitchView = getViewById(R.id.mLoopRotarySwitchView);
        mFrameLayout = getViewById(R.id.top_layout);
        mRecyclerView = getViewById(R.id.mybook_rv);
        initViews();
        initDatas();

    }

    @Override
    public void initViews() {
        setTitle("电码阅读");
        rotate3D();
        //Top书籍的宽度设置
        int width = Utils.getScreenWidth(mContext);
        mFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(width, width * 4 / 9));
        mLoopRotarySwitchView.setLayoutParams(new FrameLayout.LayoutParams(width * 2 / 5, width * 3 / 9));
        //RecyclerView初始化
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        mBookShelfAdapter = new BookShelfAdapter(mContext, DataProvider.bookShelf());
        mRecyclerView.setAdapter(mBookShelfAdapter);
    }

    @Override
    public void initDatas() {

    }

    /**
     * Property Animation中的ObjectAnimator
     */
    public void rotateyAnimRun(final View view) {
        ObjectAnimator anim = ObjectAnimator
                .ofFloat(view, "chao", 0.0F, 90.0F)//
                .setDuration(500);//
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                view.setAlpha(cVal);
                view.setRotationY(cVal);
                view.setRotationX(cVal);
            }
        });
    }

    /**
     * View Animation中的RotateAnimation（旋转）
     */
    public void animRun(View view) {
        RotateAnimation animation = new RotateAnimation(0, 45);
        animation.setDuration(2000);
        mImageView.startAnimation(animation);
    }

    /**
     * 3D旋转
     */
    public void rotate3D() {
        mLoopRotarySwitchView
                .setR(70)//设置R的大小
                .setAutoScrollDirection(LoopRotarySwitchView.AutoScrollDirection.left);//切换方向
        mLoopRotarySwitchView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void selected(int item, View view) {
//颜色的变化
            }
        });
    }
    /**
     *
     */
}
