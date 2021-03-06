
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

public abstract class SwipeBackActivity<M extends  BaseModel , P extends BasePresenter> extends RxAppCompatActivity  {


    public SwipeBackLayout mSwipeBackLayout;

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
            ButterKnife.bind(this);
            bindMVP();
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
