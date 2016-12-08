
package com.team.zhuoke.masterhelper.base;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;

import com.team.zhuoke.masterhelper.model.ContractProxy;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.List;

import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

public abstract class SwipeBackActivity<T extends  BasePresenter> extends RxAppCompatActivity implements BaseView {


    public SwipeBackLayout mSwipeBackLayout;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            processSaveInstanceState(savedInstanceState);
        }
        onActivityCreate();
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

    protected void processSaveInstanceState(Bundle savedInstanceState) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();

        if (fragments != null && fragments.size() > 0) {
            boolean showFlag = false;

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            for (int i = fragments.size() - 1; i >= 0; i--) {
                Fragment fragment = fragments.get(i);
                if (fragment != null) {
                    if (!showFlag) {
                        ft.show(fragment);
                        showFlag = true;
                    } else {
                        ft.hide(fragment);
                    }
                }
            }
            ft.commit();
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipeBackLayout.attachToActivity(this);
    }

    @Override
    public View findViewById(int id) {
        View view = super.findViewById(id);
        if (view == null && mSwipeBackLayout != null) {
            return mSwipeBackLayout.findViewById(id);
        }
        return view;
    }

    void onActivityCreate() {
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().getDecorView().setBackgroundDrawable(null);
        mSwipeBackLayout = new SwipeBackLayout(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mSwipeBackLayout.setLayoutParams(params);
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return mSwipeBackLayout;
    }

    public void setSwipeBackEnable(boolean enable) {
        mSwipeBackLayout.setEnableGesture(enable);
    }

}
