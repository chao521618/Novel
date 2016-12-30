package yueshenginfo.com.mynovel.module.news.presenter;

import java.util.Map;

import yueshenginfo.com.IBasePresenter;
import yueshenginfo.com.mynovel.module.news.dto.FinanceNewsDto;
import yueshenginfo.com.mynovel.module.news.interfaces.FinanceInterface;
import yueshenginfo.com.mynovel.module.news.model.FinanceModel;
import yueshenginfo.com.mynovel.module.news.model.impl.FinanceModelImpl;
import yueshenginfo.com.mynovel.module.news.view.FinanceView;

/**
 * Created by huchao on 2016/12/29.
 * Email 1064224874@qq.com
 */
public class FinancePresenter extends IBasePresenter<FinanceView> implements FinanceInterface {
    private FinanceModel mFinanceModel;

    public FinancePresenter(FinanceView newsView) {
        super(newsView);
    }

    @Override
    public void initialized() {
        mFinanceModel = new FinanceModelImpl();
    }

    public void getFinance(Map<String, Object> params) {
        mFinanceModel.getFinance(params,FinancePresenter.this);
    }



    @Override
    public void getFinanceResult(boolean isOk, FinanceNewsDto dto) {
        getView().getFinanceResult(isOk, dto);
    }
}
