package com.team.zhuoke.masterhelper.view.test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.base.BaseActivity;
import com.team.zhuoke.masterhelper.base.BaseView;
import com.team.zhuoke.masterhelper.model.test.SharePreferencesModel;
import com.team.zhuoke.masterhelper.model.test.SharePreferencesView;
import com.team.zhuoke.masterhelper.presenter.test.imp.SharePreferencesPresenter;
import com.team.zhuoke.masterhelper.utils.SharePreferencesHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static com.team.zhuoke.masterhelper.utils.SharePreferencesHelper.DEVICE_ID;
import static com.team.zhuoke.masterhelper.utils.SharePreferencesHelper.DEVICE_INFO;
import static com.team.zhuoke.masterhelper.utils.SharePreferencesHelper.USER_ACCOUNT;
import static com.team.zhuoke.masterhelper.utils.SharePreferencesHelper.USER_INFO;
import static com.team.zhuoke.masterhelper.utils.SharePreferencesHelper.USER_NAME;
import static com.team.zhuoke.masterhelper.utils.SharePreferencesHelper.USER_PWD;
import static com.team.zhuoke.masterhelper.utils.SharePreferencesHelper.getString;

/**
 * Created by admin on 2017/1/11.
 */

public class TestSharePreferencesActivity extends AppCompatActivity{
//    @InjectView(R.id.et_login_username)
    EditText mLoginUsername;                        //  获取用户账号的如数狂
//    @InjectView(R.id.et_login_password)
    EditText mLoginPassword;                        //  获取用户密码的输入框
//    @InjectView(R.id.cb_remember_user_info)
    CheckBox mRememberUserInfo;                     //  单选框 是否记住密码
//    @InjectView(R.id.btn_login)
    Button mLoginBtn;                               //  登录按钮 不过这里主要用于
//    @InjectView(R.id.tv_show_devices_id)
    TextView mShowDevicesIdText;                    //  用于显示设备号
    private String mDeviceId;                       //  设备号
    private static final int USER_ACCOUNT_INDEX = 1;//  用户账号的下标
    private static final int USER_PWD_INDEX = 2;    //  用户密码的下标

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_sp);

        mLoginUsername = (EditText) findViewById(R.id.et_login_username);
        mLoginPassword = (EditText) findViewById(R.id.et_login_password);
        mRememberUserInfo = (CheckBox) findViewById(R.id.cb_remember_user_info);
        mLoginBtn = (Button) findViewById(R.id.btn_login);
        mShowDevicesIdText = (TextView) findViewById(R.id.tv_show_devices_id);
        getDeviceId();
        getUserInfo();

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  保存用户名密码 勾选就记住 不勾选就清空
                if (mRememberUserInfo.isChecked()) {
                    SharePreferencesHelper.putString(USER_ACCOUNT,
                            mLoginUsername.getText().toString(), USER_INFO);
                    SharePreferencesHelper.putString(USER_PWD,
                            mLoginPassword.getText().toString(), USER_INFO);
                    //  设备号随便存一个
                    SharePreferencesHelper.putString(DEVICE_ID,
                            "HUA_WEI_1092090", DEVICE_INFO);
                } else {
                    SharePreferencesHelper.cleanSpWithName(USER_INFO);
                    SharePreferencesHelper.cleanSpWithName(DEVICE_INFO);
                }
            }
        });
    }

    /**
     * 获取用户信息 当前界面的用户信息包括用户账号和用户密码
     */
    private void getUserInfo() {
        String userAccount = SharePreferencesHelper.getString(USER_ACCOUNT, USER_INFO);
        String userPassword = SharePreferencesHelper.getString(USER_PWD, USER_INFO);
        //  判断是否存过数据
        if (!"".equals(userAccount) && !"".equals(userPassword)) {
            mRememberUserInfo.setChecked(true);
            mLoginUsername.setText(userAccount);
            mLoginPassword.setText(userPassword);
        }
    }

    /**
     * 获取设备号
     */
    private void getDeviceId() {
        String deviceId = SharePreferencesHelper.getString(DEVICE_ID, DEVICE_INFO);
        //  判断是否存过数据
        if (!"".equals(deviceId)) {
            mShowDevicesIdText.setText("设备号: " + deviceId);
        }
    }

//    @OnClick({R.id.cb_remember_user_info, R.id.btn_login})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.btn_login:
//                //  保存用户名密码 勾选就记住 不勾选就清空
//                if (mRememberUserInfo.isChecked()) {
//                    SharePreferencesHelper.putString(USER_ACCOUNT,
//                            mLoginUsername.getText().toString(), USER_INFO);
//                    SharePreferencesHelper.putString(USER_PWD,
//                            mLoginPassword.getText().toString(), USER_INFO);
//                    //  设备号随便存一个
//                    SharePreferencesHelper.putString(DEVICE_ID,
//                            "HUA_WEI_1092090", DEVICE_INFO);
//                } else {
//                    SharePreferencesHelper.cleanSpWithName(USER_INFO);
//                    SharePreferencesHelper.cleanSpWithName(DEVICE_INFO);
//                }
//                break;
//        }
//    }

//    @Override
//    public void setUserInfo(List<String> userInfo) {
//        String userAccount = userInfo.get(USER_ACCOUNT_INDEX);
//        String userPassword = userInfo.get(USER_PWD_INDEX);
//        //  判断是否存过数据
//        if (!"".equals(userAccount) && !"".equals(userPassword)) {
//            mRememberUserInfo.setChecked(true);
//            mLoginUsername.setText(userAccount);
//            mLoginPassword.setText(userPassword);
//        }
//    }
//
//    @Override
//    public void setDeviceId(String deviceId) {
//        if (!"".equals(deviceId)) {
//            mShowDevicesIdText.setText("设备号: " + deviceId);
//        }
//    }
//
//    @Override
//    public void setErrorInfo(String message) {
//
//    }
}
