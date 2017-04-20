package com.team.zhuoke.masterhelper.net.transformer;


import com.team.zhuoke.masterhelper.net.exception.ExceptionHandle;
import com.team.zhuoke.masterhelper.net.exception.ServerException;
import com.team.zhuoke.masterhelper.net.response.HttpResponse;

import rx.Observable;
import rx.functions.Func1;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：2016/11/25 下午8:11
 **/

public class ErrorTransformer<T> implements Observable.Transformer<HttpResponse<T>,T> {
    @Override
    public Observable<T> call(Observable<HttpResponse<T>> httpResponseObservable) {
//    对服务器端给出Json数据进行校验
        return httpResponseObservable.map(new Func1<HttpResponse<T>, T>() {
            @Override
            public T call(HttpResponse<T> tHttpResponse) {
                if (!tHttpResponse.getCode().equals( "0")) {
                    //如果服务器端有错误信息返回，那么抛出异常，让下面的方法去捕获异常做统一处理
                    throw  new ServerException(tHttpResponse.getMessage(),Integer.parseInt(tHttpResponse.getCode()));
                }
//                //服务器请求数据成功，返回里面的数据实体
                return tHttpResponse.getResult();
            }
//            对请求服务器出现错误信息进行拦截
        }).onErrorResumeNext(new Func1<Throwable, Observable<? extends T>>() {
            @Override
            public Observable<? extends T> call(Throwable throwable) {
                throwable.printStackTrace();
                return Observable.error(ExceptionHandle.handleException(throwable));
            }
        });
    }
    public static <T> ErrorTransformer<T> create() {
        return new ErrorTransformer<>();
    }

    private static ErrorTransformer instance = null;

    private ErrorTransformer(){
    }
    /**
     * 双重校验锁单例(线程安全)
     */
    public static <T>ErrorTransformer<T> getInstance() {
        if (instance == null) {
            synchronized (ErrorTransformer.class) {
                if (instance == null) {
                    instance = new ErrorTransformer();
                }
            }
        }
        return instance;
    }
}
