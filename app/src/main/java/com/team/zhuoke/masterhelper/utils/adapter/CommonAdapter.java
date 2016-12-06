package com.team.zhuoke.masterhelper.utils.adapter;

import android.view.ViewGroup;

import java.util.List;

/**
 * @author: kutear.guo
 * @create: 2016/12/6 14:55
 * @description:
 */

public abstract class CommonAdapter<T> extends BaseAdapter<Object, T, Object> {
    private static final String TAG = "CommonAdapter";

    public CommonAdapter(List<T> ts) {
        super(ts);
    }

    @Override
    protected BaseHolder onCreateHeaderVH(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected BaseHolder onCreateFooterVH(ViewGroup parent, int viewType) {
        return null;
    }
}
