package com.team.zhuoke.masterhelper.presenter.test.interfaces;

import com.team.zhuoke.masterhelper.base.BaseModel;
import com.team.zhuoke.masterhelper.base.BasePresenter;
import com.team.zhuoke.masterhelper.base.BaseView;
import com.team.zhuoke.masterhelper.base.CommonPresenter;
import com.team.zhuoke.masterhelper.model.annotation.Implement;
import com.team.zhuoke.masterhelper.model.test.FrescoModel;
import com.team.zhuoke.masterhelper.model.test.FrescoView;
import com.team.zhuoke.masterhelper.presenter.test.imp.FrescoPresenter;

import java.util.List;

/**
 * Created by admin on 2016/12/9.
 */

public interface FrescoDemoContract {

    interface View extends BaseView {
        //  设置数据 数据类型为List<String> 内容是链接
        void setData(List<String> girlList);

        //  设置错误信息 若List为空则显示无数据
        void setErrorInfo(String message);
    }

    interface Model extends BaseModel {
        //  获取链接列表
        List<String> girlList();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getGirlList();
    }
}
