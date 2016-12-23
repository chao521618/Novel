package yueshenginfo.com.mynovel.module.bookdetail.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yueshenginfo.com.mynovel.IBaseActivity;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.bookdetail.dto.BookDetailDto;
import yueshenginfo.com.mynovel.module.bookdetail.presenter.BookDetailPresenter;
import yueshenginfo.com.mynovel.module.bookdetail.presenter.BookDetailReviewPresenter;
import yueshenginfo.com.mynovel.module.bookdetail.view.BookDetailReviewView;
import yueshenginfo.com.mynovel.module.bookdetail.view.BookDetailView;
import yueshenginfo.com.mynovel.module.review.activity.ContainerActivity;
import yueshenginfo.com.mynovel.module.review.activity.ItemReviewActivity;
import yueshenginfo.com.mynovel.module.review.adapter.ReviewAdapter;
import yueshenginfo.com.mynovel.module.review.dto.ReviewDto;
import yueshenginfo.com.mynovel.publics.common.Constants;
import yueshenginfo.com.mynovel.publics.utils.DateUtil;
import yueshenginfo.com.mynovel.publics.utils.EmptyUtils;
import yueshenginfo.com.mynovel.publics.utils.T;
import yueshenginfo.com.mynovel.publics.utils.Utils;

public class BookDetailActivity extends IBaseActivity implements BookDetailView, BookDetailReviewView {
    @Bind(R.id.book_face_sdview)
    SimpleDraweeView bookFaceSdview;
    @Bind(R.id.book_name)
    TextView bookName;
    @Bind(R.id.book_author)
    TextView bookAuthor;
    @Bind(R.id.book_category)
    TextView bookCategory;
    @Bind(R.id.total_words_number)
    TextView totalWordsNumber;
    @Bind(R.id.update_time)
    TextView updateTime;
    @Bind(R.id.tv_person)
    TextView tvPerson;
    @Bind(R.id.reader_rate)
    TextView readerRate;
    @Bind(R.id.day_words_number)
    TextView dayWordsNumber;
    @Bind(R.id.book_desc)
    TextView bookDesc;
    @Bind(R.id.flowlayout)
    TagFlowLayout flowlayout;
    @Bind(R.id.rv_review)
    RecyclerView rvReview;
    @Bind(R.id.book_detail_community)
    TextView bookDetailCommunity;
    @Bind(R.id.book_detail_post_count)
    TextView bookDetailPostCount;
    @Bind(R.id.flowlayout_parent)
    LinearLayout flowlayoutParent;
    private String id;
    //书籍信息
    private BookDetailPresenter mBookDetailPresenter;
    private ArrayList<String> mArrayList;
    private static boolean LineCount = true;
    //书籍评论
    private ReviewAdapter mReviewAdapter;
    private ArrayList<ReviewDto.ReviewsVO> mReviewsVOLists;
    private BookDetailReviewPresenter mBookDetailReviewPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        ButterKnife.bind(this);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        setTitle("书籍详情");
        Date date = new Date();
        mArrayList = new ArrayList<>();
        mReviewsVOLists = new ArrayList<>();
        id = getIntent().getStringExtra("id");
        mBookDetailPresenter = new BookDetailPresenter(this);
        mBookDetailReviewPresenter = new BookDetailReviewPresenter(this);
        initRecyclerView();
    }

    @Override
    public void initDatas() {
        //请求书籍详情
        mBookDetailPresenter.getBookDetail(id);
        getBookDetailReview();
    }


    @Override
    public void getBookDetailResult(boolean isOk, BookDetailDto bookDetailDto) {
        if (EmptyUtils.isNotEmpty(bookDetailDto.get_id())) {
            bookName.setText(bookDetailDto.getTitle());
            bookAuthor.setText(bookDetailDto.getAuthor());
            bookCategory.setText(bookDetailDto.getCat());
            totalWordsNumber.setText(String.valueOf(bookDetailDto.getWordCount() / 10000));

            bookDetailCommunity.setText(String.format(mContext.getString(R.string.book_detail_community), bookDetailDto.getTitle()));
            bookDetailPostCount.setText(String.format(mContext.getString(R.string.book_detail_post_count), bookDetailDto.getPostCount()));
            //Java中转UTC时间字符串(含有T Z)为local时间
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//            df.setTimeZone(TimeZone.getTimeZone("UTC"));
//            try {
//                Log.e("1111",df.parse(bookDetailDto.getUpdated()).toString());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }

            //将字符串转换成时间戳
            DateUtil.str2Calendar(DateUtil.Standardtime(bookDetailDto.getUpdated()), "");
            //时间间隔方法
            String s = DateUtil.converTime(DateUtil.str2Calendar(DateUtil.Standardtime(bookDetailDto.getUpdated()), "").getTimeInMillis());
            updateTime.setText(s);
            tvPerson.setText(String.valueOf(bookDetailDto.getLatelyFollower()));
            readerRate.setText(String.valueOf(bookDetailDto.getRetentionRatio()));
            dayWordsNumber.setText(String.valueOf(bookDetailDto.getSerializeWordCount()));
            bookDesc.setText(bookDetailDto.getLongIntro());
            bookFaceSdview.setImageURI(Utils.getImgUrl(Constants.ServiceInterFace.IMG_BASE_URL + bookDetailDto.getCover()));
            if (EmptyUtils.isNotEmpty(bookDetailDto.getTags())) {
                for (String mString : bookDetailDto.getTags()) {
                    mArrayList.add(mString);
                }

                flowlayout.setAdapter(new TagAdapter<String>(mArrayList) {

                    @Override
                    public View getView(FlowLayout parent, int position, String s) {
                        TextView mTextView = (TextView) LayoutInflater.from(mContext).inflate(R.layout.tv_words, flowlayout, false);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(flowlayout.getLayoutParams());
                        params.gravity = Gravity.CENTER_VERTICAL;
                        flowlayout.setLayoutParams(params);
                        mTextView.setText(s);
                        return mTextView;
                    }
                });
            } else {
                flowlayoutParent.setVisibility(View.GONE);
            }

        }
    }

    @OnClick({R.id.add_to_shelf, R.id.begin_read, R.id.book_desc, R.id.tv_review_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_to_shelf:
                T.showShort(mContext, "添加书架");
                break;
            case R.id.begin_read:
                T.showShort(mContext, "开始阅读");
                break;
            case R.id.tv_review_more:
                Intent mIntent = new Intent(mContext, ContainerActivity.class);
                mIntent.putExtra("fragmentFlag",1);
                mIntent.putExtra("bookName",bookName.getText().toString());
                mIntent.putExtra("bookId",id);
                startActivity(mIntent);
                break;
            case R.id.book_desc:
                if (LineCount) {
                    bookDesc.setMaxLines(20);
                    LineCount = false;
                } else {
                    bookDesc.setMaxLines(4);
                    LineCount = true;
                }

                break;
        }
    }

    private void initRecyclerView() {
        rvReview.setLayoutManager(new LinearLayoutManager(mContext));
        mReviewAdapter = new ReviewAdapter(mContext, mReviewsVOLists);
        rvReview.setAdapter(mReviewAdapter);
        rvReview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Intent mIntent = new Intent(mContext, ItemReviewActivity.class);
                mIntent.putExtra("id", mReviewsVOLists.get(i).get_id());
                startActivity(mIntent);
            }
        });
    }

    //  请求书籍评论
    private void getBookDetailReview() {
        Map<String, Object> params = new HashMap<>();
        params.put("book", id);
        mBookDetailReviewPresenter.getBookDetailReview(params);
    }

    @Override
    public void getBookDetailReviewResult(boolean isOk, ReviewDto reviewDto) {
        if (isOk) {
            mReviewsVOLists.addAll(reviewDto.getReviews());

        } else {
        }
        mReviewAdapter.notifyDataSetChanged();
    }


}
