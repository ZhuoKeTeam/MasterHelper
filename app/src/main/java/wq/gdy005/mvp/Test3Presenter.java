package wq.gdy005.mvp;

import com.team.zhuoke.masterhelper.model.test.TestList;
import com.team.zhuoke.masterhelper.net.callback.RxSubscriber;
import com.team.zhuoke.masterhelper.net.exception.ResponeThrowable;

import java.util.List;

/**
 * Created by WangQing on 2016/12/9.
 */

public class Test3Presenter extends Test3Contract.Presenter {
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
