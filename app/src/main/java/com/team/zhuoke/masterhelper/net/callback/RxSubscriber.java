package com.team.zhuoke.masterhelper.net.callback;

import android.util.Log;

import com.team.zhuoke.masterhelper.net.exception.ResponeThrowable;


/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：2016/11/24 上午10:56
 **/
public  abstract class RxSubscriber<T> extends ErrorSubscriber<T> {



    @Override
    protected void onError(ResponeThrowable ex) {
        Log.e("aaaaa", "onError: " + ex.message + "code: " + ex.code);
    }

    /**
     *  开始请求网络
     */
    @Override
    public void onStart() {
        super.onStart();
        // todo some common as show loadding  and check netWork is NetworkAvailable
    }
    /**
     *   请求网络完成
     */
    @Override
    public void onCompleted() {
    }
    /**
     *  获取网络数据
     * @param t
     */
    @Override
    public void onNext(T t) {

          onSuccess(t);
    }
    public abstract  void onSuccess(T t);

}