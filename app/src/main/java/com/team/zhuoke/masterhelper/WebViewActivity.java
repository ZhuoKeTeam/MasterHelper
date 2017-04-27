package com.team.zhuoke.masterhelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * Created by renxl on 2016/11/24.
 * email: renxuelongvip@163.com
 */
public class WebViewActivity extends AppCompatActivity {

    public static final String WEB_URL = "web_url";
    public static final String WEB_TITLE = "web_title";

    private WebView mWebView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent intent = getIntent();
        String url = intent.getStringExtra(WEB_URL);
        String title = intent.getStringExtra(WEB_TITLE);
        setTitle(title);

        initView();
        mWebView.loadUrl(url);
    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.web_main);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar_webview);
        initWebView();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                webView.loadUrl(s);
                return false;
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                changeProgress(i);
            }
        });

        WebSettings webSettings = mWebView.getSettings();
        if (Utils.isNetworkConnected(getApplicationContext())) {
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        } else {
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }

        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);

    }

    private void changeProgress(int i) {
        if (i >= 0 && i < 100) {
            mProgressBar.setProgress(i);
            mProgressBar.setVisibility(View.VISIBLE);
        } else if (i == 100) {
            mProgressBar.setProgress(100);
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
