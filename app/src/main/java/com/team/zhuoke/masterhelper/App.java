package com.team.zhuoke.masterhelper;

import android.app.Application;

import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by renxl on 2016/11/22.
 * Tel: 5630
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 预加载X5
        QbSdk.initX5Environment(getApplicationContext(), null);
    }
}
