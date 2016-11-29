package com.team.zhuoke.masterhelper.fragment.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.fragment.BaseMainFragment;

import butterknife.ButterKnife;

/**
 * Created by Doraemon on 2016/11/28.
 */
public class ProfileFragment extends BaseMainFragment {
    FragmentManager fm;
    EuclidChildFragment euclidChildFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_fram, null);
        ButterKnife.inject(this, view);
        return view;
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
        fm=getChildFragmentManager();
        euclidChildFragment=new EuclidChildFragment();
        euclidChildFragment.setToolBarbackClickLister(new EuclidChildFragment.ToolBarbackClickLister() {
            @Override
            public void onBackClick() {
                openDrawer();
            }
        });
        fm.beginTransaction().add(R.id.fram_container,euclidChildFragment).show(euclidChildFragment).commit();
    }
}