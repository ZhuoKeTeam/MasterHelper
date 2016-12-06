package com.team.zhuoke.masterhelper.fragment.marster;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.fragment.BaseMainFragment;

/**
 * Created by Doraemon on 2016/11/28.
 */
public class ProfileFragment extends BaseMainFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_fram, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFragment();
    }

    private void initFragment() {
        FragmentManager fm = getChildFragmentManager();
        EuclidChildFragment euclidChildFragment = new EuclidChildFragment();
        euclidChildFragment.setToolBarBackClickLister(() -> openDrawer());
        fm.beginTransaction().add(R.id.fram_container, euclidChildFragment).show(euclidChildFragment).commit();
    }

}