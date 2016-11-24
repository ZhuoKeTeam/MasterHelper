package com.team.zhuoke.masterhelper;

import android.content.Context;
import android.os.Handler;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.Toast;

import com.team.zhuoke.masterhelper.bean.MasterBean;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

/**
 * 在这个目录下面的单元测试都需要 Android 环境，需要连接真机或者模拟器运行
 *
 * Created by WangQing on 2016/11/14.
 */
@RunWith(AndroidJUnit4.class)
public class AndroidTest {

    private static final String TAG = "AndroidTest";

    private Context context = null;

    /**
     * 带 @Before 的方法是每个单元测试都必须优先走的第一个
     */
    @Before
    public void init() {
        Log.d(TAG, "init() called");

        // 在单元测试中获取 上下文对方的方法，当然也可以直接获取 Application 对象
        context = InstrumentationRegistry.getTargetContext();
    }

    /**
     * 带 @After 的方法是每个单元测试 结束后都必须走的
     */
    @After
    public void end() {
        Log.d(TAG, "end() called");
    }

    /**
     * 带 @Test 的方法是一个单元测试
     * 这是一个例子
     */
    @Test
    public void getContext() {
        Log.i(TAG, "getContext: ");

        final Context context = InstrumentationRegistry.getTargetContext();
        new Handler(context.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, "显示时间很短： hello", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Test
    public void masterList() {

        String[] names = new String[] {"hongyang", "任玉刚", "Trinea", "胡凯", "郭霖"};

//        JSONArray jsonArray = new JSONArray();

        ArrayList list = new ArrayList();

        for (int i = 0; i < names.length; i++) {
            MasterBean masterBean = new MasterBean();

            masterBean.setName(names[i]);
            masterBean.setGrade(String.valueOf(i + 1));
            masterBean.setVip(true);
            masterBean.setWeiBo("");
            masterBean.setZhiHu("");
            masterBean.setInfo("");

            list.add(masterBean);
        }

        System.out.println(list.toString());



    }

}
