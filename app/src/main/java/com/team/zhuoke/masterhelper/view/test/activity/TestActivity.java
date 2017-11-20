package com.team.zhuoke.masterhelper.view.test.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.base.BaseActivity;
import com.team.zhuoke.masterhelper.base.BaseView;
import com.team.zhuoke.masterhelper.model.test.MasterList;
import com.team.zhuoke.masterhelper.model.test.MasterListModel;
import com.team.zhuoke.masterhelper.presenter.test.imp.MasterListPresenterImp;
import com.team.zhuoke.masterhelper.presenter.test.interfaces.MasterListContract;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：${User}
 * 电话：18810474975
 * 邮箱：18810474975@163.com
 * 版本号：
 * 类描述：
 * 修改时间：${DATA}1722
 */
public class TestActivity extends BaseActivity<MasterListModel,MasterListPresenterImp> implements MasterListContract.View {
    @BindView(R.id.btn_home)
    Button btnHome;
    @BindView(R.id.ed_data)
     EditText edData;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void onInitView(Bundle bundle) {

    }

    @OnClick(R.id.btn_home)
    public void home() {
        mPresenter.getMasterList();
    }

    @Override
    protected void onEvent() {

    }

    @Override
    protected BaseView getView() {
        return  this;
    }

    @Override
    public void MasterList(List<MasterList> masterLists) {
         edData.setText(masterLists.toString());
    }

    @Override
    public void showErrorWithStatus(String msg) {
        edData.setText(msg.toString());
    }
}
