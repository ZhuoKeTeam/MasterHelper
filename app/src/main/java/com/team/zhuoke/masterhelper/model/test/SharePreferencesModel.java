package com.team.zhuoke.masterhelper.model.test;

import com.team.zhuoke.masterhelper.presenter.test.interfaces.SharePreferencesContract;
import com.team.zhuoke.masterhelper.utils.SharePreferencesHelper;

import java.util.ArrayList;
import java.util.List;

import static com.team.zhuoke.masterhelper.utils.SharePreferencesHelper.*;

/**
 * Created by admin on 2017/1/11.
 */

public class SharePreferencesModel implements SharePreferencesContract.Model {

    @Override
    public List<String> userInfo() {
        List<String> userInfoList = new ArrayList<>();
        userInfoList.add(getString(USER_NAME, USER_INFO));
        userInfoList.add(getString(USER_ACCOUNT, USER_INFO));
        userInfoList.add(getString(USER_PWD, USER_INFO));
        return userInfoList;
    }

    @Override
    public String deviceId() {
        return getString(DEVICE_ID, DEVICE_INFO);
    }
}
