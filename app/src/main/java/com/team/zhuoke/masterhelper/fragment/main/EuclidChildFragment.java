package com.team.zhuoke.masterhelper.fragment.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.team.zhuoke.masterhelper.R;
import com.yalantis.euclid.library.EuclidFragment;
import com.yalantis.euclid.library.EuclidListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Doraemon on 2016/11/29.
 * 继承EuclidFragment 实现效果
 *还未修改成MVP模式
 */

public class EuclidChildFragment extends EuclidFragment {
    private ToolBarbackClickLister toolBarbackClickLister;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButtonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Oh hi!", Toast.LENGTH_SHORT).show();
            }
        });
        mToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toolBarbackClickLister != null) {
                    toolBarbackClickLister.onBackClick();
                }
            }
        });
    }

    @Override
    protected BaseAdapter getAdapter() {
        Map<String, Object> profileMap;
        List<Map<String, Object>> profilesList = new ArrayList<>();

        int[] avatars = {
                R.drawable.photo,
                R.drawable.photo,
                R.drawable.photo,
                R.drawable.photo,
                R.drawable.photo,
                R.drawable.photo,
                R.drawable.photo,
                R.drawable.photo,
                R.drawable.photo
        };
        String[] names = {"master1", "master1", "master1", "master1", "master1", "master1", "master1", "master1", "master1"};

        for (int i = 0; i < avatars.length; i++) {
            profileMap = new HashMap<>();
            profileMap.put(EuclidListAdapter.KEY_AVATAR, avatars[i]);
            profileMap.put(EuclidListAdapter.KEY_NAME, names[i]);
            profileMap.put(EuclidListAdapter.KEY_DESCRIPTION_SHORT, getString(R.string.lorem_ipsum_short));
            profileMap.put(EuclidListAdapter.KEY_DESCRIPTION_FULL, getString(R.string.lorem_ipsum_long));
            profilesList.add(profileMap);
        }

        return new EuclidListAdapter(getActivity(), R.layout.list_item, profilesList);
    }

    /**
     * 返回键监听
     */
    interface ToolBarbackClickLister {
        void onBackClick();
    }

    public void setToolBarbackClickLister(ToolBarbackClickLister toolBarbackClickLister) {
        this.toolBarbackClickLister = toolBarbackClickLister;
    }
}
