package yueshenginfo.com.mynovel.module.home.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yueshenginfo.com.mynovel.IBaseActivity;
import yueshenginfo.com.mynovel.R;

public class ReadActivity extends IBaseActivity {

    @Bind(R.id.read_content_bottom_setting)
    TextView readContentBottomSetting;
    @Bind(R.id.read_content_bottom_toc)
    TextView readContentBottomToc;
    @Bind(R.id.read_content_bottom_download)
    TextView readContentBottomDownload;
    @Bind(R.id.read_content_bottom_pattern)
    TextView readContentBottomPattern;
    @Bind(R.id.read_content_bottom_layout)
    LinearLayout readContentBottomLayout;
    @Bind(R.id.read_layout)
    RelativeLayout readLayout;
    private TranslateAnimation mShowAction,mHiddenAction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        ButterKnife.bind(this);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
       // this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        readLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    public void initDatas() {

    }

    @OnClick({R.id.read_content_bottom_setting, R.id.read_content_bottom_toc, R.id.read_content_bottom_download, R.id.read_content_bottom_pattern, R.id.read_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.read_content_bottom_setting:
                break;
            case R.id.read_content_bottom_toc:
                break;
            case R.id.read_content_bottom_download:
                break;
            case R.id.read_content_bottom_pattern:
                break;
            case R.id.read_layout:
                viewAnim();
                if (readContentBottomLayout.getVisibility()==View.GONE){
                    readContentBottomLayout.startAnimation(mShowAction);
                    readContentBottomLayout.setVisibility(View.VISIBLE);
                    readLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                }else {
                    readLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
                    readContentBottomLayout.startAnimation(mHiddenAction);
                    readContentBottomLayout.setVisibility(View.GONE);
                }
                //  readContentBottomLayout.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_read_bottom));
                break;
        }
    }

    /**
     * 阅读界面背景显示的动画效果与隐藏效果
     */
    private void viewAnim() {
        //底部布局的显示与消失
        mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mShowAction.setDuration(500);
        mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f);
        mHiddenAction.setDuration(300);
    }
}
