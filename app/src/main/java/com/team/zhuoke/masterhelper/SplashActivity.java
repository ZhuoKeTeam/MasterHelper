package com.team.zhuoke.masterhelper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.team.zhuoke.masterhelper.activity.MainActivity;
import com.team.zhuoke.masterhelper.utils.SharedPreferenceCommen;
import com.team.zhuoke.masterhelper.widget.PathView;

/**
 * Created by zhangchuanqiang on 2016/11/22.
 */

public class SplashActivity extends AppCompatActivity {
    PathView mPathView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mPathView=(PathView)findViewById(R.id.pathView);
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
        mPathView.getPathAnimator().
                delay(100).
                duration(1400).
                interpolator(new AccelerateDecelerateInterpolator()).
                start();
        // TODO: 2016/11/26  这个时间太短了，请修改为 3秒钟吧，最好给界面上弄个 倒计时的东西，这里容易出现内存泄漏，一定要注意避免。
        new Handler().postDelayed(() -> next(), 1800);
    }

    private void next() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
