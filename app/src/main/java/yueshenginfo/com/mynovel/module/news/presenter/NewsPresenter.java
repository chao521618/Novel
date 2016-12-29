package yueshenginfo.com.mynovel.module.news.presenter;

import java.util.Map;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.news.dto.NewsDto;
import yueshenginfo.com.mynovel.module.news.interfaces.NewsInterface;
import yueshenginfo.com.mynovel.module.news.model.NewsModel;
import yueshenginfo.com.mynovel.module.news.model.impl.NewsModelImpl;
import yueshenginfo.com.mynovel.module.news.view.NewsView;

/**
 * Created by huchao on 2016/12/29.
 * Email 1064224874@qq.com
 */
public class NewsPresenter extends IBasePresenter<NewsView> implements NewsInterface {
    private NewsModel mNewsModel;

    public NewsPresenter(NewsView newsView) {
        super(newsView);
    }

    @Override
    public void initialized() {
        mNewsModel = new NewsModelImpl();
    }

    public void getNews(Map<String, Object> params) {
    mNewsModel.getNews(params,NewsPresenter.this);
    }

    @Override
    public void getNewsResult(boolean isOk, NewsDto dto) {
        getView().getNewsResult(isOk, dto);
    }
}
