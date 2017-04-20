package com.team.zhuoke.masterhelper.fragment.marster;

import android.content.Context;

import com.team.zhuoke.masterhelper.base.BaseModel;
import com.team.zhuoke.masterhelper.base.BasePresenter;
import com.team.zhuoke.masterhelper.base.BaseView;
import com.team.zhuoke.masterhelper.fragment.MasterInfoBean;

import java.util.List;

import rx.Observable;

/**
 * Created by WangQing on 2017/4/20.
 */

public class MasterContract {

    interface View extends BaseView {
        void setData(List<MasterInfoBean> masterInfoBeanList);
        void setErrorInfo(String message);
    }

    interface Model extends BaseModel {
        Observable<List<MasterInfoBean>> getMasterData(Context context);
    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
         abstract void getMasterList();
    }
}
