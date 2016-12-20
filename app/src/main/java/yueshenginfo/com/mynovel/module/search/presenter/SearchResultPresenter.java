package yueshenginfo.com.mynovel.module.search.presenter;

import java.util.Map;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.search.dto.SeachBooksDto;
import yueshenginfo.com.mynovel.module.search.interfaces.SearchResultInterface;
import yueshenginfo.com.mynovel.module.search.model.SearchResultModel;
import yueshenginfo.com.mynovel.module.search.model.impl.SearchResultModelImpl;
import yueshenginfo.com.mynovel.module.search.view.SearchResultView;

/**
 * Created by huchao on 2016/12/19.
 * Email 1064224874@qq.com
 */
public class SearchResultPresenter extends IBasePresenter<SearchResultView> implements SearchResultInterface {
    private SearchResultModel mSearchResultModel;

    public SearchResultPresenter(SearchResultView searchResultView) {
        super(searchResultView);
    }

    @Override
    public void initialized() {
        mSearchResultModel = new SearchResultModelImpl();
    }

    public void getSearch(Map<String, Object> params) {
        mSearchResultModel.getSearch(params, SearchResultPresenter.this);
    }

    @Override
    public void getSearchResult(boolean isOk, SeachBooksDto dto) {
getView().getSearchResult(isOk,dto);
    }
}
