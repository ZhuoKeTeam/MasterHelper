package com.team.zhuoke.masterhelper.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.team.zhuoke.masterhelper.model.ContractProxy;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;


/**
 * 作者：gaoyin
 * 电话：18810474975
 * 邮箱：18810474975@163.com
 * 版本号：1.0
 * 类描述：
 * 1.所有的Activity都需要继承BaseActivity获取Presenter实例对象
 * 2.BaseActivity类对Activity一些基本的生命周期进行控制 --->  范围包含网络,事件(绑定)订阅,取消,DB,以及涉及到的广播等
 * 3.此类可以进行接入友盟页面统计,以及BUG统计等!
 * 4.根据项目需求 待扩展。。。
 * <p>
 * 备注消息：
 * 修改时间：2016/11/8 下午3:46
 **/
public abstract class BaseActivity<P extends BasePresenter> extends RxAppCompatActivity {

    //    定义Presenter
    protected P mPresenter;

    //    获取布局资源文件
    protected abstract int getLayoutId();

    //    初始化数据
    protected abstract void onInitView(Bundle bundle);

    protected abstract BaseView getBaseView();

    protected abstract Class getContract();


    private Class presenterClass;
    private Class modelClass;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != 0) {
//            设置布局资源文件
            setContentView(getLayoutId());
//            注解绑定
            ButterKnife.inject(this);

            createMVPClass();

            bindPresenter();
            bindModel();
            onInitView(savedInstanceState);
        }
    }

    private void createMVPClass() {
        Class[] classes = getContract().getClasses();
        for (int i = 0; i < classes.length; i++) {
            Class clazz = classes[i];

            String name = clazz.getSimpleName();

            if (!TextUtils.isEmpty(name)) {
                if (name.equals("Presenter")) {
                    setPresenterClass(clazz);
                } else if (name.equals("Model")) {
                    setModelClass(clazz);
                }
            } else {
                try {
                    throw new MVPException("getContract().getClasses() getSimpleName() is Null!");
                } catch (MVPException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void bindModel() {
        if (getModelClass() != null && mPresenter != null) {
            getModelImpl();
        }
    }

    private <T> T getModelImpl() {
        return ContractProxy.getInstance().bindModel(getModelClass(), mPresenter);
    }

    private void bindPresenter() {
        if (getPresenterClass() != null) {
            mPresenter = getPresenterImpl();
            mPresenter.mContext = this;
        }
    }

    private <T> T getPresenterImpl() {
        return ContractProxy.getInstance().bindPresenter(getPresenterClass(), getBaseView());
    }

    @Override
    protected void onStart() {
        if (mPresenter != null && !mPresenter.isViewBind()) {
            ContractProxy.getInstance().bindPresenter(getPresenterClass(), getBaseView());
            ContractProxy.getInstance().bindModel(getModelClass(), mPresenter);
            mPresenter.mContext = this;
        }
        super.onStart();
    }

    /**
     * activity摧毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);
        if (mPresenter != null) {
            ContractProxy.getInstance().unbindPresenter(getPresenterClass(), getBaseView());
            ContractProxy.getInstance().unbindModel(getModelClass(), mPresenter);
            mPresenter.detachView();
        }
    }

    public Class getPresenterClass() {
        return presenterClass;
    }

    public void setPresenterClass(Class presenterClass) {
        this.presenterClass = presenterClass;
    }

    public Class getModelClass() {
        return modelClass;
    }

    public void setModelClass(Class modelClass) {
        this.modelClass = modelClass;
    }
}
