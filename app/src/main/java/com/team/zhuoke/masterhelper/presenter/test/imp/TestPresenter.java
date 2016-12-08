package com.team.zhuoke.masterhelper.presenter.test.imp;

import com.team.zhuoke.masterhelper.base.BasePresenter;
import com.team.zhuoke.masterhelper.model.test.TestList;
import com.team.zhuoke.masterhelper.model.test.TestModel;
import com.team.zhuoke.masterhelper.model.test.TestView;
import com.team.zhuoke.masterhelper.net.callback.RxSubscriber;
import com.team.zhuoke.masterhelper.net.exception.ResponeThrowable;
import com.team.zhuoke.masterhelper.presenter.test.interfaces.TestContract;

import java.util.List;

/**
 * 测试 presenter
 *
 * Created by WangQing on 2016/12/7.
 */

public class TestPresenter extends BasePresenter<TestView, TestModel> implements TestContract.Presenter {

    @Override
    public void getTestList() {
        addSubscribe(mModel.testList(mContext).subscribe(new RxSubscriber<List<TestList>>() {
            @Override
            public void onSuccess(List<TestList> testLists) {
                mView.setData(testLists.toString());
            }

            @Override
            protected void onError(ResponeThrowable ex) {
                super.onError(ex);
                mView.setErrorInfo(ex.message);
            }
        }));
    }
}
