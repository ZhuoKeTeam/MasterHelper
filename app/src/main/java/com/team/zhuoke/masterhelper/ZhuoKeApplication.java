package com.team.zhuoke.masterhelper;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.team.zhuoke.masterhelper.api.NetWorkApi;
import com.team.zhuoke.masterhelper.net.config.NetWorkConfiguration;
import com.team.zhuoke.masterhelper.net.http.HttpUtils;
import com.team.zhuoke.masterhelper.utils.L;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;
import com.zhy.http.okhttp.https.HttpsUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Application
 * Created by WangQing on 2016/11/22.
 */

public class ZhuoKeApplication extends Application {
    private static ZhuoKeApplication instance=null;

    public static ZhuoKeApplication getInstance(){
        return instance;
    }

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        sContext = this;

        L.init();
        initOkHttpUtils();

        Fresco.initialize(sContext);
		
		// 预加载X5
//        QbSdk.initX5Environment(getApplicationContext(), null);
    }

    /**
     * 初始化网络请求
     */
    private void initOkHttpUtils() {
        // Cookie
        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));
        // Https
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .cookieJar(cookieJar)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
        /**
         *  网络配置
         */
        NetWorkConfiguration configuration=new NetWorkConfiguration(this)
                                                            .baseUrl(NetWorkApi.baseUrl)
                                                            .isCache(true)
                                                            .isDiskCache(true)
                                                            .isMemoryCache(false);
        HttpUtils.setConFiguration(configuration);


    }

    public static Context getContext() {
        return sContext;
    }

}
