package yueshenginfo.com.mynovel.module.home.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yueshenginfo.com.mynovel.IBaseActivity;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.home.dto.BookChapterDto;
import yueshenginfo.com.mynovel.module.home.dto.BookContentDto;
import yueshenginfo.com.mynovel.module.home.presenter.BookChapterPresenter;
import yueshenginfo.com.mynovel.module.home.presenter.BookContentPresenter;
import yueshenginfo.com.mynovel.module.home.read.BookContentCustomView;
import yueshenginfo.com.mynovel.module.home.read.Chapter;
import yueshenginfo.com.mynovel.module.home.read.Page;
import yueshenginfo.com.mynovel.module.home.read.ReaderAdapter;
import yueshenginfo.com.mynovel.module.home.read.SlowViewPager;
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
    @Bind(R.id.reader_current)
    BookContentCustomView readerCurrent;
    @Bind(R.id.reader_next)
    BookContentCustomView readerNext;
    @Bind(R.id.reader_prev)
    BookContentCustomView readerPrev;
    @Bind(R.id.viewpager_reader)
    SlowViewPager viewpagerReader;

    private TranslateAnimation mShowAction, mHiddenAction;
    private BookChapterPresenter mBookChapterPresenter;
    private BookContentPresenter mBookContentPresenter;
    private ArrayList<String> bookContentLinkList;

    private String id;
    private List<BookChapterDto.mixToc.Chapters> mChapterList = new ArrayList<>();
    private int currentChapter = 1;
    private List<String> listCurrent;
    private List<Page> pageList = new ArrayList<Page>();
    /**
     * 当前章节分页数
     */
    private int pageCount = 0;
    private int currentItem = 0;
    /**
     * 当前章节
     */
    private Chapter current;

    /**
     * 下一章
     */
    private Chapter nextChapter;

    /**
     * 上一章
     */
    private Chapter prevChapter;
    /**
     * 屏幕三分之一的宽度。
     */
    private int oneThird = 300;
    private List<String> listNext;

    private List<String> listPrev;
    private ReaderAdapter adapter;
    private float lastX = 0;
    private float currentX = 0;
    private long lastClickTime = 0;
    private long currentClickTime = 0;

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
        id = getIntent().getStringExtra("bookId");
        listCurrent = new ArrayList<>();
        readLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        mBookChapterPresenter = new BookChapterPresenter(this);
        mBookContentPresenter = new BookContentPresenter(this);
        bookContentLinkList = new ArrayList<>();
        initViewPager();
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
        mBookChapterPresenter.getBookChapter(id);
    }

    @Override
    public void getBookChapterResult(boolean isOk, BookChapterDto dto) {
        if (isOk) {
//
//            mChapterList.addAll(dto.mixToc.chapters);
//            mPageWidget = new PageWidget(this, id, mChapterList, new ReadListener());
//            readContentLayout.addView(mPageWidget);
//            if (!mPageWidget.isPrepared) {
//              //  mPageWidget.init(curTheme);
//            } else {
//                mPageWidget.jumpToChapter(currentChapter);
//            }
        }


    }

    //小说的某一章内容请求
    private void getBookContent() {
        mBookContentPresenter.getBookContent("http://www.luoqiu.com/read/57830/15222014.html");
    }

    @Override
    public void getBookContentResult(boolean isOk, final BookContentDto dto) {
        bookName.setText(dto.getChapter().getTitle());

//
        readerCurrent.setText(dto.getChapter().getBody());
//        readerCurrent.onPage(new OnReaderPageListener() {
//            @Override
//            public void onSuccess(List<String> pages) {
//
//                listCurrent = pages;
//                pageList.addAll(covertPageList(pages, dto));
//                pageCount = pages.size();
//                int pageindex = 0;
//                pageindex = getNewPageIndex(dto.getChapter().getBody().length(), listCurrent);
//                //tvPage.setText(String.format(PAGE_FORMAT, pageindex + 1, pageCount));
//                adapter.notifyDataSetChanged();
//                if (pageindex < pages.size()) {
//                    viewpagerReader.setCurrentItem(pageindex, false);
//                }
//            }
//        });
    }

    private List<Page> covertPageList(List<String> list, BookContentDto result) {
        Page p = null;
        List<Page> pages = new ArrayList<Page>();
        for (int i = 0; i < list.size(); i++) {
            p = new Page();
            p.pageIndex = i + 1;
            p.pageSize = list.size();
            p.chapterTitle = result.getChapter().getTitle();
            p.content = list.get(i);
            pages.add(p);
        }
        return pages;
    }

    private void initViewPager() {
        adapter = new ReaderAdapter(mContext, pageList);
        viewpagerReader.setOffscreenPageLimit(3);
        viewpagerReader.setAdapter(adapter);
        viewpagerReader.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                Page p = pageList.get(arg0);

//                if (nextChapter != null && nextChapter.getId().equals(p.chapterId)) {
//                    current = nextChapter;
//                    listCurrent = listNext;
//                    currentChapterId = current.getId();
//                    if (nextChapter.next != null) getNext(nextChapter.next.getId());
//                }
//
//                if (prevChapter != null && prevChapter.getId().equals(p.chapterId)) {
//                    current = prevChapter;
//                    listCurrent = listPrev;
//                    currentChapterId = current.getId();
//                    if (prevChapter.prev != null) getPrev(prevChapter.prev.getId());
//                }
//
//                currentItem = arg0;
//                if (isAdded()) {
//                    currentChapterPageIndex = pageList.get(arg0).pageIndex;
//                    setTitle(pageList.get(arg0).chapterTitle);
//                    setPager(String.format(PAGE_FORMAT, pageList.get(arg0).pageIndex,
//                            pageList.get(arg0).pageSize));
//                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

        // View onTouch
        viewpagerReader.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = event.getRawX();
                        lastClickTime = System.currentTimeMillis();
                        break;
                    case MotionEvent.ACTION_UP:
                        currentClickTime = System.currentTimeMillis();
                        currentX = event.getRawX();
                        float offsetX = Math.abs(currentX - lastX);
//                        if ((currentClickTime - lastClickTime) <= CLICK_INTERVAL
//                                && offsetX < mScaledTouchSlop) {
//
//                        }
                        handleOnClick();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    /**
     * 处理点击事件。
     */
    private void handleOnClick() {
        if (lastX < oneThird) {
            if (currentItem > 0) {
                viewpagerReader.setCurrentItem(currentItem - 1);
            }

        } else if (lastX > oneThird * 2) {
            if (currentItem < adapter.getCount()) {
                viewpagerReader.setCurrentItem(currentItem + 1);
            }
        }
//        else if (clickListener != null) {
//            clickListener.onClick();
//        }
    }

    private int getNewPageIndex(int readCount, List<String> pages) {
        int total = 0;
        int pageindex = 0;
        for (int i = 0; i < pages.size(); i++) {
            total = total + pages.get(i).length();
            if (total >= readCount) {
                pageindex = i;
                break;
            }
        }

        if (pageindex < 0) pageindex = 0;

        return pageindex;
    }
}



