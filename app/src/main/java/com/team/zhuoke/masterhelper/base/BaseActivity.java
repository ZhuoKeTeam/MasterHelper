package com.team.zhuoke.masterhelper.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.team.zhuoke.masterhelper.model.ContractProxy;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

import static android.os.Build.VERSION_CODES.M;


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
public abstract class BaseActivity<P extends BasePresenter> extends RxAppCompatActivity implements  BaseView<P> {

//    定义Presenter
    protected  P mPresenter;

//    获取布局资源文件
    protected  abstract  int getLayoutId();

//    初始化数据

    protected  abstract void onInitView(Bundle bundle);

//    初始化事件Event

    protected  abstract  void onEvent();

//    获得抽取接口Presenter对象
    protected  abstract Class getPresenterClazz();
    //    获得抽取接口Model对象
    protected  abstract Class getModelClazz();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getLayoutId()!=0)
        {
//            设置布局资源文件
             setContentView(getLayoutId());
//            注解绑定
            ButterKnife.inject(this);
            bindPresenter();
            bindModel();
            onInitView(savedInstanceState);
            onEvent();
        }
    }
    private  void bindModel()
    {
        if(getModelClazz()!=null&&mPresenter!=null)
        {
              getModelImpl();
        }

    }
    private <T> T getModelImpl()
    {

        return ContractProxy.getInstance().bindModel(getModelClazz(),mPresenter);
    }
    private  void bindPresenter()
    {
          if(getPresenterClazz()!=null)
          {
               mPresenter=getPresenterImpl();
              mPresenter.mContext=this;
          }
    }

    private <T> T getPresenterImpl()
    {
        return ContractProxy.getInstance().bindPresenter(getPresenterClazz(),this);
    }

    @Override
    protected void onStart() {

        if(mPresenter!=null&&!mPresenter.isViewBind())
        {
            ContractProxy.getInstance().bindPresenter(getPresenterClazz(),this);
            ContractProxy.getInstance().bindModel(getModelClazz(),mPresenter);
            mPresenter.mContext=this;
        }
        super.onStart();
    }

    /**
     *  activity摧毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
       ButterKnife.reset(this);
        if(mPresenter!=null)
        {
            ContractProxy.getInstance().unbindPresenter(getPresenterClazz(),this);
            ContractProxy.getInstance().unbindModel(getModelClazz(),mPresenter);
            mPresenter.detachView();
        }
    }
}
