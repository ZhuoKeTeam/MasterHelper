package com.team.zhuoke.masterhelper;

import android.content.Context;
import android.os.Handler;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.Toast;

import com.team.zhuoke.masterhelper.bean.MasterBean;
import com.team.zhuoke.masterhelper.utils.L;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import okhttp3.Call;

/**
 * 在这个目录下面的单元测试都需要 Android 环境，需要连接真机或者模拟器运行
 *
 * 如果测试耗时的操作，例如网络请求或者读取本地文件 一般直接使用 Thread.sleep(毫秒数) 这种方法就可以，但是可能不准确。
 * 准确的方法是 使用 CountDownLatch 来控制。
 *
 * {@link AndroidTest.testGuPiao()}
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
    public void LogTest() {
        L.i("test...i");
        L.e("test...e");
        L.d("test...d");
    }

    @Test
    public void testGuPiao() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        String url = "https://gupiao.caimao.com/weixin/note/square/success/1?p=1";
        RequestCall requestCall = OkHttpUtils.get().url(url).build();
        Log.i(TAG, "testNetWork: " + url);
        requestCall.execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.d(TAG, "onError() called with: call = [" + call + "], e = [" + e + "], id = [" + id + "]");
                countDownLatch.countDown();
            }

            @Override
            public void onResponse(String response, int id) {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //以上方法比下面的 Sleep 好
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
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

            try {
                JSONObject jsonObject = new JSONObject(masterBean.toString());
                L.json(jsonObject.toString());
                list.add(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        System.out.println(list.toString());
    }

    @Test
    public void getMasterInfo() {
        String url = "http://zkteam.wilddogio.com/master_list.json";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback(){

                    @Override
                    public void onError(Call call, Exception e, int id) {

                        Log.d(TAG, "onError() called with: call = [" + call + "], e = [" + e + "], id = [" + id + "]");
                    }

                    @Override
                    public void onResponse(String response, int id) {

                        Log.d(TAG, "onResponse() called with: response = [" + response + "], id = [" + id + "]");
                    }
                });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
