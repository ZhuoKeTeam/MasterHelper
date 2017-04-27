package com.team.zhuoke.masterhelper.activity;

import android.content.Context;
import android.content.Intent;

import com.team.zhuoke.masterhelper.WebViewActivity;

/**
 * Created by renxl
 * On 2017/4/27 16:00.
 */

public class PageCtrl {

    /**
     * 跳转到大神文章详情WebView界面
     *
     * @param context 上下文
     * @param url     网址
     */
    public static void startArticleDetailActivity(Context context, String url, String title) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(WebViewActivity.WEB_URL, url);
        intent.putExtra(WebViewActivity.WEB_TITLE, title);
        context.startActivity(intent);
    }

}
