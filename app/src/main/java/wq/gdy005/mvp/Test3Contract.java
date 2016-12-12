package wq.gdy005.mvp;

import android.content.Context;

import com.team.zhuoke.masterhelper.base.BaseModel;
import com.team.zhuoke.masterhelper.base.BasePresenter;
import com.team.zhuoke.masterhelper.base.BaseView;
import com.team.zhuoke.masterhelper.model.test.TestList;

import java.util.List;

import rx.Observable;

/**
 * Created by WangQing on 2016/12/9.
 */

public interface Test3Contract {

    interface View extends BaseView {
        void setData(String s);
        void setErrorInfo(String message);
    }

    interface Model extends BaseModel {
        Observable<List<TestList>> testList(Context context);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        abstract void getTestList();
    }
}
