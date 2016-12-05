package com.team.zhuoke.masterhelper.base;

import android.content.Context;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.os.Build.VERSION_CODES.M;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *         1.获取绑定View实例传递到子类中进行调用!
 *
 *         2.注销View实例
 *
 *         3. 绑定Model 并进行实例化
 *
 *         4.注销Model
 *
 *         5.通过Rxjava绑定View 中activity和fragment生命周期方法 !
 *
 *
 *  备注消息：
 *  修改时间：2016/11/8 下午5:07
 **/
public abstract   class BasePresenter<V extends  BaseView, M extends  BaseModel> implements Presenter<V,M> {


   protected Context mContext;

    protected V mView;

    protected M mModel;

    protected CompositeSubscription mCompositeSubscription;

    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }
    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

//    获取绑定View实例
    @Override
    public void attachView(V view) {
          this.mView=view;
    }
//    获取绑定Model层实例
    @Override
    public void attachModel(M m) {
        this.mModel=m;
    }


    public M getModel() {
        return mModel;
    }
    //    注销mModel实例
    @Override
    public void detachModel() {
        this.mModel=null;
    }

    //    注销View实例
    @Override
    public void detachView() {
         this.mView=null;
        unSubscribe();
    }

    public V getView() {
        return mView;
    }

    public boolean isViewBind()
    {
        return mView!=null;
    }

}
