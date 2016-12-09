package com.team.zhuoke.masterhelper.presenter.test.interfaces;

import android.content.Context;

import com.team.zhuoke.masterhelper.base.BaseModel;
import com.team.zhuoke.masterhelper.base.BasePresenter;
import com.team.zhuoke.masterhelper.base.BaseView;
import com.team.zhuoke.masterhelper.base.CommonPresenter;
import com.team.zhuoke.masterhelper.model.annotation.Implement;
import com.team.zhuoke.masterhelper.model.test.TestList;
import com.team.zhuoke.masterhelper.model.test.TestModel;
import com.team.zhuoke.masterhelper.model.test.TestView;
import com.team.zhuoke.masterhelper.presenter.test.imp.TestPresenter;

import java.util.List;

import rx.Observable;

/**
 * 测试
 *
 * 在这里约定我可能需要的东西，可以一目了然的看清想之间的依赖关系，从而可以更好的控制该类 以及子类
 *
 * Created by WangQing on 2016/12/7.
 */
public interface TestContract {

    interface View extends BaseView {
        void setData(String s);
        void setErrorInfo(String message);
    }

    interface Model extends BaseModel {
        Observable<List<TestList>> testList(Context context);
    }

     abstract class Presenter extends BasePresenter<View,Model> {
         public  abstract   void getTestList();
    }

}
