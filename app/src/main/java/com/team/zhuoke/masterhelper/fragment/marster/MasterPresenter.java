package com.team.zhuoke.masterhelper.fragment.marster;


import com.team.zhuoke.masterhelper.fragment.MasterInfoBean;
import com.team.zhuoke.masterhelper.net.callback.RxSubscriber;
import com.team.zhuoke.masterhelper.net.exception.ResponeThrowable;

import java.util.List;

/**
 * Created by WangQing on 2017/4/20.
 */

public class MasterPresenter extends MasterContract.Presenter{

    @Override
    void getMasterList() {
        addSubscribe(mModel.getMasterData(mContext).subscribe(new RxSubscriber<List<MasterInfoBean>>() {
            @Override
            public void onSuccess(List<MasterInfoBean> masterInfoBeanList) {
                mView.setData(masterInfoBeanList);
            }

            @Override
            protected void onError(ResponeThrowable ex) {
                super.onError(ex);
                mView.setErrorInfo(ex.getMessage());
            }
        }));
    }
}
