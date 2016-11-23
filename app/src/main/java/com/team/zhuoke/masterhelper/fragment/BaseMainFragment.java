package com.team.zhuoke.masterhelper.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kutear on 16-11-23.
 * 主页部分的Fragment的基类
 */

public class BaseMainFragment extends Fragment {
    private OnDrawerController mDrawerController;
    protected AppCompatActivity mActivity;

    public interface OnDrawerController {
        void openDrawer();

        void closeDrawer();
    }

    protected void openDrawer() {
        if (mDrawerController != null) {
            mDrawerController.openDrawer();
        }
    }

    private void closeDrawer() {
        if (mDrawerController != null) {
            mDrawerController.closeDrawer();
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDrawerController) {
            mDrawerController = (OnDrawerController) context;
        }

        if (context instanceof AppCompatActivity) {
            mActivity = (AppCompatActivity) context;
        }

    }
}
