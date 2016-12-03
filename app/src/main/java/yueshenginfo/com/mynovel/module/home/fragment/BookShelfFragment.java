package yueshenginfo.com.mynovel.module.home.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.dalong.library.listener.OnItemSelectedListener;
import com.dalong.library.view.LoopRotarySwitchView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.ViewHolder;

import yueshenginfo.com.mynovel.IBaseFragment;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.activity.ReadActivity;
import yueshenginfo.com.mynovel.module.home.adapter.BookShelfAdapter;
import yueshenginfo.com.mynovel.publics.common.DataProvider;
import yueshenginfo.com.mynovel.publics.utils.T;
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
    private PopupWindow mPopupWindow;
    private View mView;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        mView = inflater.inflate(R.layout.bookshelf_fragment_layout, container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mImageView = getViewById(R.id.image);
        mLoopRotarySwitchView = getViewById(R.id.mLoopRotarySwitchView);
        mFrameLayout = getViewById(R.id.top_layout);
        mRecyclerView = getViewById(R.id.mybook_rv);
        Fresco.initialize(mContext);
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
        View footerView = getView(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBottomView1();
            }
        });
        mBookShelfAdapter.addFooterView(footerView);
        mRecyclerView.setAdapter(mBookShelfAdapter);
        initListener();
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
     * 添加尾部布局
     */
    private View getView(View.OnClickListener listener) {
        View view = View.inflate(mContext, R.layout.bookshelf_item_layout, null);
        int width = Utils.getScreenWidth(mContext) / 3;
        //item的一个布局
        LinearLayout mLinearLayout = (LinearLayout) view.findViewById(R.id.bookshelf_item_layout);
        //图片
        SimpleDraweeView mSimpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.bookshelf_item_view);
        //图片底下的一个布局
        LinearLayout mBookIntroductionLayout = (LinearLayout) view.findViewById(R.id.book_inroduction);
        mLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(width, width * 3 / 2));
        mSimpleDraweeView.setLayoutParams(new LinearLayout.LayoutParams(width * 4 / 5, width * 30 / 29));
        mBookIntroductionLayout.setLayoutParams(new LinearLayout.LayoutParams(width * 4 / 5, ViewGroup.LayoutParams.WRAP_CONTENT));
        //设置点击
        mLinearLayout.setOnClickListener(listener);
        return view;
    }

    /**
     * 添加所显示的view
     * method:PopupWindow
     * describution:PopupWindow从低端弹出后，他的父布局不会出现禁用的效果，
     */
    private void getBottonView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bottom_view_layout, null);
        mPopupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setContentView(view);
        mPopupWindow.showAtLocation(mView, Gravity.BOTTOM, 0, 0);
    }

    /**
     * method:DialogPlus
     */
    private void getBottomView1() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bottom_view_layout, null);
        DialogPlus mDialogPlus = DialogPlus.newDialog(mContext)
                .setContentHolder(new ViewHolder(view))
                .setFooter(R.layout.bottom_cancel_layout)
                .setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(DialogPlus dialog, View view) {
                        switch (view.getId()) {
                            case R.id.go_books:
                                T.showShort(mContext, "热书推荐");
                                break;
                            case R.id.import_books:
                                T.showShort(mContext, "导入本地书籍");
                                break;
                            case R.id.wifi_transmission:
                                T.showShort(mContext, "WIFI传书");
                                break;
                            case R.id.botton_view_cancel:
                                dialog.dismiss();
                                break;
                        }
                    }
                }).create();
        mDialogPlus.show();
    }

    /**
     * 书籍item的点击事件
     */
    private void initListener() {
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Intent mIntent=new Intent(mContext, ReadActivity.class);
                startActivity(mIntent);
            }

        });
    }
}
