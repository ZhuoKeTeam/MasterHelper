package com.team.zhuoke.masterhelper.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.team.zhuoke.masterhelper.ZhuoKeApplication;

import java.io.File;

/**
 * // TODO: 2016/11/26  变量名起的看不下去啦。。。 FIRSTBLOOD --> FIRST_BLOOD  看起来是不是比以前好看很多？
 *
 * Created by zhangchuanqiang on 2016/11/22.
 */

public class SharedPreferenceCommen {
    Context mContext;
    /**
     * 第一次进入app
     */
    public static String FIRSTBLOOD = "frist_blood";

    public static final String SHAREDPREFERENCES = "sf";

    public static SharedPreferences share_pf;

    private static SharedPreferences getShare_pf() {
        if (share_pf == null) {
            share_pf = ZhuoKeApplication.getInstance().getSharedPreferences(SHAREDPREFERENCES, Context.MODE_PRIVATE);
        }
        return share_pf;
    }

    /**
     * // TODO: 2016/11/26  什么情况下需要清除 SP 文件呢??? 举个例子
     * * 清除本应用SharedPreference(/data/data/com.xxx.xxx/shared_prefs) * * @param
     * context
     */
    public static void cleanSharedPreference(Context context) {
        deleteFilesByDirectory(new File("/data/data/"
                + context.getPackageName() + "/shared_prefs"));
    }

    private static void deleteFilesByDirectory(File directory) {
        if (directory != null && directory.exists() && directory.isDirectory()) {
            for (File item : directory.listFiles()) {
                item.delete();
            }
        }
    }

    /**
     * 存储是否是第一次进入状态
     *
     * // TODO: 2016/11/26 这块看着有问题啊，有两个地方需要修改。
     *
     * @param fristBlood
     */
    public static void setFristBlood(Boolean fristBlood) {
        getShare_pf().edit().putBoolean(FIRSTBLOOD, fristBlood);
    }

    /**
     * 获取状态
     */
    public static boolean getFristBliid(String firstBlood) {
       return getShare_pf().getBoolean(firstBlood, true);
    }
}
