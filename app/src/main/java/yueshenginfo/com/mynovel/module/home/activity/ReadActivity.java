package yueshenginfo.com.mynovel.module.home.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yueshenginfo.com.mynovel.IBaseActivity;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.dto.BookChapterDto;
import yueshenginfo.com.mynovel.module.home.dto.BookContentDto;
import yueshenginfo.com.mynovel.module.home.presenter.BookChapterPresenter;
import yueshenginfo.com.mynovel.module.home.presenter.BookContentPresenter;
import yueshenginfo.com.mynovel.module.home.view.BookChapterView;
import yueshenginfo.com.mynovel.module.home.view.BookContentView;

public class ReadActivity extends IBaseActivity implements BookChapterView, BookContentView {

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
    @Bind(R.id.read_content_layout)
    FrameLayout readContentLayout;
    @Bind(R.id.book_name)
    TextView bookName;
    private TranslateAnimation mShowAction, mHiddenAction;
    private BookChapterPresenter mBookChapterPresenter;
    private BookContentCustomView mBookContentCustomView;
    private BookContentPresenter mBookContentPresenter;
    private ArrayList<String> bookContentLinkList;
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
        mBookChapterPresenter = new BookChapterPresenter(this);
        mBookContentPresenter = new BookContentPresenter(this);
        bookContentLinkList = new ArrayList<>();
    }

    @Override
    public void initDatas() {
        getBookChapter();
        getBookContent();
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
                if (readContentBottomLayout.getVisibility() == View.GONE) {
                    readContentBottomLayout.startAnimation(mShowAction);
                    readContentBottomLayout.setVisibility(View.VISIBLE);
                    readLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                } else {
                    readLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
                  //  readContentBottomLayout.startAnimation(mHiddenAction);
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

    /**
     * 小说章节请求
     */
    private void getBookChapter() {
        mBookChapterPresenter.getBookChapter("5721d80d843a87e12703f469");
    }

    @Override
    public void getBookChapterResult(boolean isOk, BookChapterDto dto) {

    }

    //小说章节请求
    private void getBookContent() {
        mBookContentPresenter.getBookContent("http://www.luoqiu.com/read/57830/15222014.html");
    }

    @Override
    public void getBookContentResult(boolean isOk, BookContentDto dto) {
        bookName.setText(dto.getChapter().getTitle());
       mBookContentCustomView = new BookContentCustomView(mContext, dto.getChapter().getBody());
        readContentLayout.addView(mBookContentCustomView);
       // mBookContentCustomView.setText(dto.getChapter().getBody());
    }

}



