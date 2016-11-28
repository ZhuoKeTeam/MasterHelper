package com.team.zhuoke.masterhelper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by renxl on 2016/11/24.
 * email: renxuelongvip@163.com
 */

public class Utils {

    // TODO: 2016/11/26 总感觉怪怪的，有问题，需要好好看看，尤其是一些异常需要及时捕获
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            return true;
        }
        return false;
    }

}
