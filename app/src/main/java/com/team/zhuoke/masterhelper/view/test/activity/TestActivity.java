package com.team.zhuoke.masterhelper.view.test.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.base.BaseActivity;
import com.team.zhuoke.masterhelper.model.test.MasterList;
import com.team.zhuoke.masterhelper.presenter.test.imp.MasterListPresenterImp;
import com.team.zhuoke.masterhelper.presenter.test.interfaces.MasterListContract;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：${User}
 * 电话：18810474975
 * 邮箱：18810474975@163.com
 * 版本号：
 * 类描述：
 * 修改时间：${DATA}1722
 */

public class TestActivity extends BaseActivity<MasterListPresenterImp> implements MasterListContract.View {
    @InjectView(R.id.btn_home)
    Button btnHome;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void onInitView(Bundle bundle) {


    }
    @OnClick(R.id.btn_home)
    public void home()
    {
        mPresenter.getMasterList();
    }

    @Override
    protected void onEvent() {

    }

    @Override
    protected Class getContractClazz() {
        return MasterListContract.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    @Override
    public void showSuccessWithStatus(String msg) {

    }

    @Override
    public void showErrorWithStatus(String msg) {
        Toast.makeText(getApplicationContext(),msg.toString(),Toast.LENGTH_LONG).show();
    }
    @Override
    public void showsInfoWithStatus(String msg) {

    }

    @Override
    public void showWithProgress(String msg) {

    }

    @Override
    public void dismiss() {

    }

    @Override
    public void MasterList(List<MasterList> masterLists) {
        Toast.makeText(getApplicationContext(),masterLists.toString(),Toast.LENGTH_LONG).show();
    }
}
