package com.team.zhuoke.masterhelper.utils.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: kutear.guo
 * @create: 2016/12/6 14:34
 * @description:
 */

public abstract class BaseAdapter<HeaderData, NormalData, FooterData> extends RecyclerView.Adapter<BaseAdapter.BaseHolder> {
    private List<NormalData> innerNormalList = new ArrayList<>();    //Normal节点
    private List<HeaderData> innerHeaderList = new ArrayList<>();    //Header节点
    private List<FooterData> innerFooterList = new ArrayList<>();    //Header节点
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NORMAL = 1;
    private static final int TYPE_FOOTER = 2;


    public BaseAdapter(List<NormalData> dataList) {
        this.innerNormalList.addAll(dataList);
    }

    public void setNormal(List<NormalData> dataList, boolean remove) {
        if (remove) {
            this.innerNormalList.clear();
        }
        this.innerNormalList.addAll(dataList);
    }

    public void setHeader(List<HeaderData> dataList, boolean remove) {
        if (remove) {
            this.innerHeaderList.clear();
        }
        this.innerHeaderList.addAll(dataList);
    }


    public void setFooter(List<FooterData> dataList, boolean remove) {
        if (remove) {
            this.innerFooterList.clear();
        }
        this.innerFooterList.addAll(dataList);
    }

    private static int getSizeOfList(List list) {
        return list != null ? list.size() : 0;
    }

    private int getHeaderCount() {
        return getSizeOfList(innerHeaderList);
    }

    private int getNormalCount() {
        return getSizeOfList(innerNormalList);
    }

    private int getFooterCount() {
        return getSizeOfList(innerFooterList);
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_FOOTER:
                return onCreateFooterVH(parent, viewType);
            case TYPE_HEADER:
                return onCreateHeaderVH(parent, viewType);
            case TYPE_NORMAL:
                return onCreateNormalVH(parent, viewType);
        }
        return null;
    }

    protected abstract BaseHolder onCreateHeaderVH(ViewGroup parent, int viewType);

    protected abstract BaseHolder onCreateNormalVH(ViewGroup parent, int viewType);

    protected abstract BaseHolder onCreateFooterVH(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        holder.bindData(getDataFromPosition(position));
    }

    private Object getDataFromPosition(int position) {
        int header = getHeaderCount();
        if (position < header) {
            return innerHeaderList.get(position);
        }
        int normal = getNormalCount();
        if (position < header + normal) {
            return innerNormalList.get(position - header);
        }
        int footer = getFooterCount();
        if (position < header + normal + footer) {
            return innerFooterList.get(position - header - normal);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public int getItemViewType(int position) {
        int header = getHeaderCount();
        if (position < header) {
            return TYPE_HEADER;
        }
        int normal = getNormalCount();
        if (position < header + normal) {
            return TYPE_NORMAL;
        }
        int footer = getFooterCount();
        if (position < header + normal + footer) {
            return TYPE_FOOTER;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public int getItemCount() {
        return getFooterCount() + getNormalCount() + getHeaderCount();
    }

    public static abstract class BaseHolder<T> extends RecyclerView.ViewHolder {
        protected View container;

        public BaseHolder(View itemView) {
            super(itemView);
            this.container = itemView;
        }

        public void bindData(T data) {
            onCover(container, data);
        }

        protected abstract void onCover(View view, T data);


    }

}
