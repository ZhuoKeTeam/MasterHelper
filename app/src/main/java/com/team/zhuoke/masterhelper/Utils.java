package com.team.zhuoke.masterhelper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.team.zhuoke.masterhelper.utils.L;

/**
 * Created by renxl on 2016/11/24.
 * email: renxuelongvip@163.com
 */

public class Utils {

    public static boolean isNetworkConnected(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null;
        } catch (Exception e) {
            L.i(e.getMessage());
        }
        return false;
    }

}
