package com.team.zhuoke.masterhelper;

import android.content.Context;

import com.team.zhuoke.masterhelper.activity.WebViewActivity;

/**
 * Created by renxl on 2016/11/28.
 * email: renxuelongvip@163.com
 */

public class PageCtrl {
    public static void startWebActivity(Context context, String url, String title) {
        WebViewActivity.showWebViewActivity(context, url, title);
    }
}
