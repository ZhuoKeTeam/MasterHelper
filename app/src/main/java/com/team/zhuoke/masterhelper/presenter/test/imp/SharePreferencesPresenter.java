package com.team.zhuoke.masterhelper.presenter.test.imp;

import com.team.zhuoke.masterhelper.presenter.test.interfaces.SharePreferencesContract;

import java.util.List;

/**
 * Created by admin on 2017/1/11.
 */

public class SharePreferencesPresenter extends SharePreferencesContract.Presenter {

    @Override
    public void getUserInfo() {
        List<String> userInfoList = mModel.userInfo();
        if (userInfoList != null) {
            mView.setUserInfo(userInfoList);
        } else {
            mView.setErrorInfo("暂无数据");
        }
    }

    @Override
    public void getDeviceId() {
        String deviceId = mModel.deviceId();
        if (!"".equals(deviceId)) {
            mView.setDeviceId(deviceId);
        } else {
            mView.setErrorInfo("暂无数据");
        }
    }
}
