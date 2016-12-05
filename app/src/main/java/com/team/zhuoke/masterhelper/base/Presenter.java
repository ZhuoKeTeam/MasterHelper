package com.team.zhuoke.masterhelper.base;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：2016/11/8 下午5:03
 **/
public interface Presenter<View,Model> {
//    绑定View控件
    void attachView(View view);
//    绑定Model
    void attachModel(Model model);
//    注销View控件
    void detachView();
    //    注销Model对象
    void detachModel();

}
