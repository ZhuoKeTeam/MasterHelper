package com.team.zhuoke.masterhelper.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.team.zhuoke.masterhelper.model.ContractProxy;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;


/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *            1.所有的Activity都需要继承BaseActivity获取Presenter实例对象
 *            2.BaseActivity类对Activity一些基本的生命周期进行控制 --->  范围包含网络,事件(绑定)订阅,取消,DB,以及涉及到的广播等
 *            3.此类可以进行接入友盟页面统计,以及BUG统计等!
 *            4.根据项目需求 待扩展。。。
 *
 *  备注消息：
 *  修改时间：2016/11/8 下午3:46
 **/
public abstract class BaseActivity<M extends  BaseModel , P extends BasePresenter> extends RxAppCompatActivity  {

//    定义Presenter
    protected  P mPresenter;

//    获取布局资源文件
    protected  abstract  int getLayoutId();

//    初始化数据

    protected  abstract void onInitView(Bundle bundle);

//    初始化事件Event

    protected  abstract  void onEvent();

    //   获取抽取View对象
    protected   abstract BaseView getView();
    //    获得抽取接口Model对象
    protected   Class getModelClazz()  {
        return (Class<M>)ContractProxy.getModelClazz(getClass(), 0);
    }
    //    获得抽取接口Presenter对象
    protected    Class getPresenterClazz()  {
        return (Class<P>)ContractProxy.getPresnterClazz(getClass(), 1);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getLayoutId()!=0)
        {
//            设置布局资源文件
             setContentView(getLayoutId());
            bindMVP();
            //        注解绑定
            ButterKnife.bind(this);
            onInitView(savedInstanceState);
            onEvent();
        }
    }

    /**
     *  获取presenter 实例
     */
    private  void bindMVP()
    {
          if(getPresenterClazz()!=null)
          {
               mPresenter=getPresenterImpl();
               mPresenter.mContext=this;
               bindVM();
          }
    }
    private <T> T getPresenterImpl()
    {
        return ContractProxy.getInstance().presenter(getPresenterClazz());
    }
    @Override
    protected void onStart() {
        if(mPresenter==null)
        {
            bindMVP();
        }
        super.onStart();
    }
    private  void bindVM()
    {
        if(mPresenter!=null&&!mPresenter.isViewBind()&&getModelClazz()!=null&&getView()!=null)
        {
            ContractProxy.getInstance().bindModel(getModelClazz(),mPresenter);
            ContractProxy.getInstance().bindView(getView(),mPresenter);
            mPresenter.mContext=this;
        }
    }

    /**
     *  activity摧毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null)
        {
            ContractProxy.getInstance().unbindView(getView(),mPresenter);
            ContractProxy.getInstance().unbindModel(getModelClazz(),mPresenter);
        }
    }
}
