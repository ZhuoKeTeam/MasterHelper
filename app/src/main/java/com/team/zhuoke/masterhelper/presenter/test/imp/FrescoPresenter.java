package com.team.zhuoke.masterhelper.presenter.test.imp;

import com.team.zhuoke.masterhelper.base.BasePresenter;
import com.team.zhuoke.masterhelper.model.test.FrescoModel;
import com.team.zhuoke.masterhelper.model.test.FrescoView;
import com.team.zhuoke.masterhelper.presenter.test.interfaces.FrescoDemoContract;

import java.util.List;

/**
 * Created by admin on 2016/12/9.
 */

public class FrescoPresenter extends FrescoDemoContract.Presenter {

    @Override
    public void getGirlList() {

        List<String> girlList = mModel.girlList();
        if (girlList != null) {
            mView.setData(girlList);
        } else {
            mView.setErrorInfo("暂无数据");
        }
    }
}
