package com.team.zhuoke.masterhelper.model.test;

import android.content.Context;

import com.team.zhuoke.masterhelper.api.TestApi.TestAPI2;
import com.team.zhuoke.masterhelper.net.http.HttpUtils;
import com.team.zhuoke.masterhelper.net.transformer.DefaultTransformer;
import com.team.zhuoke.masterhelper.presenter.test.interfaces.TestContract;

import java.util.List;

import rx.Observable;

/**
 * 添加数据层模块
 * <p>
 * Created by WangQing on 2016/12/7.
 */

public class TestModel implements TestContract.Model {

    @Override
    public Observable<List<TestList>> testList(Context context) {

        return HttpUtils.getInstance(context)
                .getRetofitClinet()
                .builder(TestAPI2.class)
                .getTestList()
                .compose(new DefaultTransformer<>());
    }

}
