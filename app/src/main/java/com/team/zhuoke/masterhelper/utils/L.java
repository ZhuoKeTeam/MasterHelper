package com.team.zhuoke.masterhelper.utils;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Settings;
import com.team.zhuoke.masterhelper.BuildConfig;

/**
 * // TODO: 2016/11/26 Demo 或者 单元测试呢？？？ 其他人只有要怎么用呢？
 *
 * Created by Long
 * on 2016/11/24.
 */

public class L {

    private static final String DEFAULT_TAG = "masterhelper";

    //no instance
    private L() {
    }

    public static void init() {

        init(DEFAULT_TAG)
        .methodCount(3)
        .logLevel(BuildConfig.DEBUG ? LogLevel.FULL : LogLevel.NONE);
    }

    public static Settings init(String tag) {
        return Logger.init(tag);
    }

    public static void d(String message, Object... args) {
        Logger.d(message, args);
    }

    public static void d(Object object) {
        Logger.d(object);
    }

    public static void e(String message, Object... args) {
        Logger.e(message, args);
    }

    public static void e(Throwable throwable, String message, Object... args) {
        Logger.e(throwable, message, args);
    }

    public static void i(String message, Object... args) {
        Logger.i(message, args);
    }

    public static void v(String message, Object... args) {
        Logger.v(message, args);
    }

    public static void w(String message, Object... args) {
        Logger.w(message, args);
    }

    public static void wtf(String message, Object... args) {
        Logger.wtf(message, args);
    }

    public static void json(String json) {
        Logger.json(json);
    }

    public static void xml(String xml) {
        Logger.xml(xml);
    }
}
