package wq.gdy005.mvp;

import android.content.Context;

import com.team.zhuoke.masterhelper.base.BaseModel;
import com.team.zhuoke.masterhelper.base.BasePresenter;
import com.team.zhuoke.masterhelper.base.BaseView;
import com.team.zhuoke.masterhelper.model.test.TestList;
import com.team.zhuoke.masterhelper.net.callback.RxSubscriber;
import com.team.zhuoke.masterhelper.net.exception.ResponeThrowable;
import com.team.zhuoke.masterhelper.net.http.HttpUtils;
import com.team.zhuoke.masterhelper.net.transformer.DefaultTransformer;

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

    class Test3Model implements Model {

        @Override
        public Observable<List<TestList>> testList(Context context) {
            return HttpUtils.getInstance(context).getRetofitClinet()
                    .builder(TestAPI3.class)
                    .getTestList()
                    .compose(new DefaultTransformer<>());
        }
    }


    class Test3Presenter extends Presenter {
        @Override
        void getTestList() {

            addSubscribe(mModel.testList(mContext).subscribe(new RxSubscriber<List<TestList>>() {
                @Override
                public void onSuccess(List<TestList> testLists) {
                    mView.setData(testLists.toString());
                }

                @Override
                protected void onError(ResponeThrowable ex) {
                    super.onError(ex);
                    mView.setErrorInfo(ex.getMessage());
                }
            }));
        }
    }
}
