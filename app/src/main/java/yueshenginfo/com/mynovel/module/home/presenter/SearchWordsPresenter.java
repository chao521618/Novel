package yueshenginfo.com.mynovel.module.home.presenter;

import java.util.Map;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.home.dto.KeyWordsDto;
import yueshenginfo.com.mynovel.module.home.interfaces.SearchWordsInterface;
import yueshenginfo.com.mynovel.module.home.model.SearchWordsModel;
import yueshenginfo.com.mynovel.module.home.model.impl.SearchWordsModelImpl;
import yueshenginfo.com.mynovel.module.home.view.SearchWordsView;

/**
 * Created by huchao on 2016/12/16.
 * Email 1064224874@qq.com
 */
public class SearchWordsPresenter extends IBasePresenter<SearchWordsView> implements SearchWordsInterface {
    private SearchWordsModel mSearchWordsModel;

    public SearchWordsPresenter(SearchWordsView searchWordsView) {
        super(searchWordsView);
    }

    @Override
    public void initialized() {
        mSearchWordsModel = new SearchWordsModelImpl();
    }
    public void getSearchWords(Map<String, Object> params) {
        mSearchWordsModel.getSearchWords(params, SearchWordsPresenter.this);
    }
    @Override
    public void getSearchWordsResult(boolean isOk, KeyWordsDto dto) {
        getView().getSearchWordsResult(isOk, dto);
    }
}
