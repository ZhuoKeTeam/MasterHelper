package com.team.zhuoke.masterhelper.base;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：  定义View中需要实现的方法
 *  备注消息：
 *  修改时间：2016/11/8 下午4:44
 **/
public interface BaseView<P> {

    /**
     *  提示成功信息
     * @param msg
     */
    void showSuccessWithStatus(String msg);

    /**
     *  提示错误信息
     * @param msg
     */
    void showErrorWithStatus(String msg);

    /**
     *  提示消息
     * @param msg
     */
    void showsInfoWithStatus(String msg);
    /**
     *  进度框
     * @param msg
     */
    void showWithProgress(String msg);

    /**
     *
     */
    void dismiss();
}
