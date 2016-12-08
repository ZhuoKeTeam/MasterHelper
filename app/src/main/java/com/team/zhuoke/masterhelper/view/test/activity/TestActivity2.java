package com.team.zhuoke.masterhelper.view.test.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.base.BaseActivity;
import com.team.zhuoke.masterhelper.base.BaseView;
import com.team.zhuoke.masterhelper.model.test.TestView;
import com.team.zhuoke.masterhelper.presenter.test.imp.TestPresenter;
import com.team.zhuoke.masterhelper.presenter.test.interfaces.TestContract;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by WangQing on 2016/12/7.
 */

public class TestActivity2 extends BaseActivity<TestPresenter> implements TestView {


    @InjectView(R.id.edit_text)
    EditText editText;
    @InjectView(R.id.btn_home)
    Button btnHome;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test2;
    }

    @Override
    protected void onInitView(Bundle bundle) {

    }

    @Override
    protected BaseView getBaseView() {
        return this;
    }

    @Override
    protected Class getContract() {
        return TestContract.class;
    }

    @Override
    public void setData(String s) {

        editText.setText(s);
    }

    @Override
    public void setErrorInfo(String message) {
        editText.setText(message);
    }

    @OnClick(R.id.btn_home)
    public void onClick() {
        mPresenter.getTestList();
    }

}
