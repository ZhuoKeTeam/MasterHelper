package com.team.zhuoke.masterhelper.utils.adapter;

import android.view.ViewGroup;

import java.util.List;

/**
 * @author: kutear.guo
 * @create: 2016/12/6 14:57
 * @description:
 */

public abstract class CommonHeaderAdapter<H, N> extends BaseAdapter<H, N, Object> {
    private static final String TAG = "CommonHeaderAdapter";

    public CommonHeaderAdapter(List<N> ns) {
        super(ns);
    }

    @Override
    protected BaseHolder onCreateFooterVH(ViewGroup parent, int viewType) {
        return null;
    }
}
