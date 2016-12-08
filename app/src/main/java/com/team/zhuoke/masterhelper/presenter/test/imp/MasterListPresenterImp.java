package com.team.zhuoke.masterhelper.presenter.test.imp;

import com.team.zhuoke.masterhelper.model.annotation.Implement;
import com.team.zhuoke.masterhelper.model.test.MasterList;
import com.team.zhuoke.masterhelper.net.callback.RxSubscriber;
import com.team.zhuoke.masterhelper.net.exception.ResponeThrowable;
import com.team.zhuoke.masterhelper.presenter.test.interfaces.MasterListContract;
import com.team.zhuoke.masterhelper.utils.L;

import java.util.List;

import static android.R.attr.y;
import static java.lang.Thread.currentThread;

/**
 * 作者：${User}
 * 电话：18810474975
 * 邮箱：18810474975@163.com
 * 版本号：
 *
 * 类描述：  presenter 层     作为model层与view层桥梁 ,进行数据传输 !
 * 修改时间：${DATA}1717
 */
public  class MasterListPresenterImp  extends  MasterListContract.Presenter {
    public void getMasterList() {
           addSubscribe(mModel.MasterList(mContext).subscribe(new RxSubscriber<List<MasterList>>() {
            @Override
            public void onSuccess(List<MasterList> masterLists) {
                mView.MasterList(masterLists);
            }
            @Override
            protected void onError(ResponeThrowable ex) {
                super.onError(ex);
                mView.showErrorWithStatus(ex.message);
            }
        }));


//        L.e("model对象为:",mModel.toString());
//        HttpUtils.getInstance(mContext)
//                .setLoadDiskCache(false)
//                .setLoadMemoryCache(false)
//                .getRetofitClinet()
//                .builder(TestApi.class)
//                .getMasterList()
////               进行预处理
//                .compose(new DefaultTransformer<List<MasterList>>())
////               绑定当前activity或者fragment 与Observable 的生命周期
////                .compose(mContext.<List<MasterList>>bindToLifecycle())
//                .subscribe(new RxSubscriber<List<MasterList>>() {
//                    @Override
//                    public void onSuccess(List<MasterList> columnDetails) {
//                         mView.MasterList(columnDetails);
//
//                    }
//                    @Override
//                    public void onError(ResponeThrowable e) {
//                      mView.showErrorWithStatus(e.message);
//                    }
//                });

    }

}
