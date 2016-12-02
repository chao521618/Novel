package yueshenginfo.com.mynovel.module.home.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        ButterKnife.bind(this);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initDatas() {

    }
}
