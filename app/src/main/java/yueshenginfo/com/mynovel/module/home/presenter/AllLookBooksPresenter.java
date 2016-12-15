package yueshenginfo.com.mynovel.module.home.presenter;

import java.util.Map;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.home.dto.AllLookBooksDto;
import yueshenginfo.com.mynovel.module.home.interfaces.AllLookBooksInterface;
import yueshenginfo.com.mynovel.module.home.model.AllLookBooksModel;
import yueshenginfo.com.mynovel.module.home.model.impl.AllLookBooksModelImpl;
import yueshenginfo.com.mynovel.module.home.view.AllLookBooksView;

/**
 * Created by huchao on 2016/12/15.
 * Email 1064224874@qq.com
 */
public class AllLookBooksPresenter extends IBasePresenter<AllLookBooksView> implements AllLookBooksInterface {
    private AllLookBooksModel mAllLookBooksModel;

    public AllLookBooksPresenter(AllLookBooksView allLookBooksView) {
        super(allLookBooksView);
    }

    @Override
    public void getAllLookBooksResult(boolean isOk, AllLookBooksDto dto) {
        getView().getAllLookBooksResult(isOk, dto);
    }

    @Override
    public void initialized() {
        mAllLookBooksModel = new AllLookBooksModelImpl();
    }

    public void getAllLookBooks(Map<String, Object> params) {
        mAllLookBooksModel.getAllLookBooks(params, AllLookBooksPresenter.this);
    }
}
