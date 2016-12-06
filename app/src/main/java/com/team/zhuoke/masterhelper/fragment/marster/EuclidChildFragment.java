package com.team.zhuoke.masterhelper.fragment.marster;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.utils.backfragmentutils.BackFragment;
import com.yalantis.euclid.library.EuclidFragment;
import com.yalantis.euclid.library.EuclidListAdapter;
import com.yalantis.euclid.library.EuclidState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Doraemon on 2016/11/29.
 * 继承EuclidFragment 实现效果
 * 还未修改成MVP模式
 */

public class EuclidChildFragment extends EuclidFragment implements BackFragment {
    private ToolBarBackClickLister toolBarBackClickLister;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButtonProfile.setOnClickListener(v -> Toast.makeText(getActivity(), "Oh hi!", Toast.LENGTH_SHORT).show());
        mToolbarBack.setImageResource(R.drawable.ic_menu_white_24dp);
        mToolbarBack.setScaleType(ImageView.ScaleType.CENTER);
        mToolbarBack.setOnClickListener(view1 -> {
            if (toolBarBackClickLister != null) {
                toolBarBackClickLister.onBackClick();
            }
        });
        setTitle("大神");
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

    public void setToolBarBackClickLister(ToolBarBackClickLister toolBarBackClickLister) {
        this.toolBarBackClickLister = toolBarBackClickLister;
    }

    @Override
    public boolean onBackPressed() {
        if (getState() != EuclidState.Closed) {
            animateCloseProfileDetails();
            return true;
        }
        return false;
    }

    @Override
    public int getBackPriority() {
        return 0;
    }

    /**
     * 返回键监听
     */
    interface ToolBarBackClickLister {
        void onBackClick();
    }
}
