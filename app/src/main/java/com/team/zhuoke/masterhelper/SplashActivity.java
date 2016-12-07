package com.team.zhuoke.masterhelper;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.team.zhuoke.masterhelper.activity.MainActivity;
import com.team.zhuoke.masterhelper.utils.SharedPreferenceCommen;
import com.team.zhuoke.masterhelper.widget.PathView;

/**
 * Created by zhangchuanqiang on 2016/11/22.
 */

public class SplashActivity extends AppCompatActivity {
    PathView mPathView;
    private static final int COUNTDOWN = 3000;
    private CountDownTimer mTimer;
    private TextView mCountDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mPathView = (PathView) findViewById(R.id.pathView);
        mCountDown=(TextView) findViewById(R.id.tv_countDown);
        initView();
    }

    private void initView() {
        mTimer=new CountDownTimer(COUNTDOWN,1000) {
            @Override
            public void onTick(long l) {
                mCountDown.setText(""+l/1000);
            }

            @Override
            public void onFinish() {
                mCountDown.setText("0");
            }
        };
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
                duration(2000).
                interpolator(new AccelerateDecelerateInterpolator()).
                start();
        mTimer.start();
        new Handler().postDelayed(() -> next(), COUNTDOWN);
    }

    private void next() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
