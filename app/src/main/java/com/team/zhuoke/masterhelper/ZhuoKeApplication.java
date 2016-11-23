package com.team.zhuoke.masterhelper;

import android.app.Application;

/**
 * Application
 * Created by WangQing on 2016/11/22.
 */

public class ZhuoKeApplication extends Application {
    private static ZhuoKeApplication instance=null;

    public static ZhuoKeApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }
}
