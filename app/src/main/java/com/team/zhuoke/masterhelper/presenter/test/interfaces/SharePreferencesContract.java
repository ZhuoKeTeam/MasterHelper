package com.team.zhuoke.masterhelper.presenter.test.interfaces;

import com.team.zhuoke.masterhelper.base.BaseModel;
import com.team.zhuoke.masterhelper.base.BasePresenter;
import com.team.zhuoke.masterhelper.base.BaseView;

import java.util.List;

/**
 * Created by admin on 2017/1/11.
 */

public interface SharePreferencesContract {

    interface View extends BaseView {
        //  设置数据 数据类型为List<String>
        void setUserInfo(List<String> userInfo);

        //  设置数据 数据类型为List<String>
        void setDeviceId(String deviceId);

        //  设置错误信息 若List为空则显示无数据
        void setErrorInfo(String message);
    }

    interface Model extends BaseModel {
        //  获取用户信息
        List<String>  userInfo();

        //  获取设备号
        String deviceId();
    }

    abstract class Presenter extends BasePresenter<SharePreferencesContract.View, SharePreferencesContract.Model> {
        public abstract void getUserInfo();

        public abstract void getDeviceId();
    }
}
