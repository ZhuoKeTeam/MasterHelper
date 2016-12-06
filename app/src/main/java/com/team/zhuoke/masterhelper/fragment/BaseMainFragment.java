package com.team.zhuoke.masterhelper.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.team.zhuoke.masterhelper.utils.backfragmentutils.BackFragment;

/**
 * Created by kutear on 16-11-23.
 * 主页部分的Fragment的基类
 */

public class BaseMainFragment extends Fragment implements BackFragment{
    private OnDrawerController mDrawerController;
    protected AppCompatActivity mActivity;

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public int getBackPriority() {
        return 0;
    }

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
