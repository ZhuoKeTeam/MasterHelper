package com.team.zhuoke.masterhelper.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.zhuoke.masterhelper.model.ContractProxy;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;

import static android.os.Build.VERSION_CODES.M;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：2016/11/14 上午11:28
 **/
public abstract class BaseFragment<T extends BasePresenter> extends RxFragment implements BaseView<T> {

    protected View rootView;
    protected Context mContext = null;//context

    //    定义Presenter
    protected  T mPresenter;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutId() != 0) {
            rootView = inflater.inflate(getLayoutId(), null);
        } else {
            rootView = super.onCreateView(inflater, container, savedInstanceState);
        }
        ButterKnife.inject(this, rootView);
        bindPresenter();
        bindModel();
        onInitView(savedInstanceState);
        onEvent();
        return rootView;
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
            mPresenter.mContext=getActivity();
        }
    }

    private <T> T getPresenterImpl()
    {
        return ContractProxy.getInstance().bindPresenter(getPresenterClazz(),this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivity();
    }

    @Override
    public void onStart() {
        if(mPresenter!=null&&!mPresenter.isViewBind())
        {
            ContractProxy.getInstance().bindPresenter(getPresenterClazz(),this);
            ContractProxy.getInstance().bindModel(getModelClazz(),mPresenter);
            mPresenter.mContext=getActivity();
        }
        super.onStart();
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindPresenter();
    }
    @Override
    public void onDestroy() {
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
