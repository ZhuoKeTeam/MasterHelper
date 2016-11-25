package com.team.zhuoke.masterhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// TODO: 2016/11/26  这个写的太简单了吧。。。  只写了一个布局？  至少要把数据源 放到 Activity 里面的测试数据嘛，否则这个类的意义就不是很大，应该多封装下，自己体会下，看看别的 app,好好想想。
public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }
}
