package com.team.zhuoke.masterhelper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.team.zhuoke.masterhelper.utils.SharedPreferenceCommen;

/**
 * Created by zhangchuanqiang on 2016/11/22.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        boolean firstblood = SharedPreferenceCommen.getFristBliid(SharedPreferenceCommen.FIRSTBLOOD);
        if (firstblood) {
            // TODO: 2016/11/22 引导页
            normal();
        } else {
            normal();
        }
    }

    /**
     * 正常启动
     */
    private void normal() {
        new Handler().postDelayed(() -> next(), 1500);
    }

    private void next() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
