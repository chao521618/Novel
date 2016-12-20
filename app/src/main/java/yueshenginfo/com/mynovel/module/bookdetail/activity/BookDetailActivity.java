package yueshenginfo.com.mynovel.module.bookdetail.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yueshenginfo.com.mynovel.IBaseActivity;
import yueshenginfo.com.mynovel.R;
import yueshenginfo.com.mynovel.module.bookdetail.dto.BookDetailDto;
import yueshenginfo.com.mynovel.module.bookdetail.presenter.BookDetailPresenter;
import yueshenginfo.com.mynovel.module.bookdetail.view.BookDetailView;
import yueshenginfo.com.mynovel.publics.common.Constants;
import yueshenginfo.com.mynovel.publics.utils.DateUtil;
import yueshenginfo.com.mynovel.publics.utils.EmptyUtils;
import yueshenginfo.com.mynovel.publics.utils.T;
import yueshenginfo.com.mynovel.publics.utils.Utils;

public class BookDetailActivity extends IBaseActivity implements BookDetailView {
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
    private String id;
    private BookDetailPresenter mBookDetailPresenter;
    private ArrayList<String> mArrayList;


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
        Log.e("1", String.valueOf(System.currentTimeMillis()));
        id = getIntent().getStringExtra("id");
        mBookDetailPresenter = new BookDetailPresenter(this);
    }

    @Override
    public void initDatas() {
        //请求书籍详情
        mBookDetailPresenter.getBookDetail(id);
    }


    @Override
    public void getBookDetailResult(boolean isOk, BookDetailDto bookDetailDto) {
        if (EmptyUtils.isNotEmpty(bookDetailDto.get_id())) {
            bookName.setText(bookDetailDto.getTitle());
            bookAuthor.setText(bookDetailDto.getAuthor());
            bookCategory.setText(bookDetailDto.getCat());
            totalWordsNumber.setText(String.valueOf(bookDetailDto.getWordCount() / 10000));
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
            for (String mString : bookDetailDto.getTags()) {
                mArrayList.add(mString);
            }
            flowlayout.setAdapter(new TagAdapter<String>(mArrayList) {

                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    TextView mTextView = (TextView) LayoutInflater.from(mContext).inflate(R.layout.tv_words, parent, false);

//                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(parent.getLayoutParams());
//                    params.gravity = Gravity.CENTER_VERTICAL;
//                    parent.setLayoutParams(params);
                    mTextView.setText(s);
                    return mTextView;
                }
            });
        }
    }

    @OnClick({R.id.add_to_shelf, R.id.begin_read, R.id.book_desc})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_to_shelf:
                T.showShort(mContext,"添加书架");
                break;
            case R.id.begin_read:
                T.showShort(mContext,"开始阅读");
                break;
            case R.id.book_desc:
                if (bookDesc.getLineCount()<=4){
                    bookDesc.setMaxLines(20);
                }else  {
                    bookDesc.setMaxLines(4);
                }

                break;
        }
    }
}
