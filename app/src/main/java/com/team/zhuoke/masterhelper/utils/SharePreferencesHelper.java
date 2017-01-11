package com.team.zhuoke.masterhelper.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.team.zhuoke.masterhelper.ZhuoKeApplication;

/**
 * SharePreferences帮助类  暂时是写了存String的  拿来给大家看一下
 * Created by Gzw on 16/7/8.
 */
public class SharePreferencesHelper {
    private static final String TAG = "SharePreferencesHelper";
    /**
     * TagName区域
     */
    public static final String USER_INFO = "user_info";                         //  用户信息
    public static final String DEVICE_INFO = "phone_info";                      //  用户设备信息
    /**
     * Key区域
     */
    public static final String USER_ACCOUNT = "user_account";                   //  USER_INFO中的用户账号
    public static final String USER_PWD = "user_pwd";                           //  USER_INFO中的用户密码
    public static final String USER_NAME = "user_name";                         //  USER_INFO中的用户名称
    public static final String DEVICE_ID = "device_id";                         //  DEVICE_INFO中的设备Id 区分不同设备的唯一编号
    private static final Context CONTEXT = ZhuoKeApplication.getContext();      //  上下文对象

    /**
     * 用Sp存String类型数据
     *
     * @param key     键 如:USER_ACCOUNT
     * @param value   值 如:获取到的用户账号
     * @param tagName 存到那个Sp中 如:用户账号密码存到用户信息中
     */
    public static void putString(String key, String value, String tagName) {
        SharedPreferences sp = getSharePreferences(tagName);
        if (sp != null) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(key, value);
            editor.commit();
        }
    }

    /**
     * 获取对应的TagName的SharedPreferences
     *
     * @param tagName
     * @return
     */
    private static SharedPreferences getSharePreferences(String tagName) {
        return CONTEXT.getSharedPreferences(tagName, Context.MODE_PRIVATE);
    }

    /**
     * 获取存储的Sting
     *
     * @param key     存的时候的键 如:USER_ACCOUNT
     * @param tagName 是哪个部分   如:USER_INFO
     * @return 返回获取的到值, 默认值为"" (如果有需要修改 后面可以重载一个自定义默认值的方法)
     */
    public static String getString(String key, String tagName) {
        SharedPreferences sp = getSharePreferences(tagName);
        return sp.getString(key, "");
    }

    /**
     * 快速获取用户姓名
     * 举例的方法, 比如我项目中需要频繁的拿到用户姓名, 可以直接将其封装快速使用
     * @return
     */
    public static String getUserName() {
        String userName = getString(USER_NAME, USER_INFO);
        return userName;
    }

    /**
     * 清除对应部分的存过的数据
     * 我之前遇到过版本升级清除已经存储的账号密码
     *
     * @param tagName 对应部分 如:USER_INFO中的所有储存的内容
     */
    public static void cleanSpWithName(String tagName) {
        SharedPreferences sp = getSharePreferences(tagName);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }

}
