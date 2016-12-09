package wq.gdy005.mvp;

import android.content.Context;

import com.team.zhuoke.masterhelper.model.test.TestList;
import com.team.zhuoke.masterhelper.net.http.HttpUtils;
import com.team.zhuoke.masterhelper.net.transformer.DefaultTransformer;

import java.util.List;

import rx.Observable;

/**
 * Created by WangQing on 2016/12/9.
 */

public class Test3Model implements Test3Contract.Model {

    @Override
    public Observable<List<TestList>> testList(Context context) {
        return HttpUtils.getInstance(context).getRetofitClinet()
                .builder(TestAPI3.class)
                .getTestList()
                .compose(new DefaultTransformer<>());
    }
}
