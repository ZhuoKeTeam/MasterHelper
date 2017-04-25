package com.team.zhuoke.masterhelper.fragment.marster;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.fragment.ArticleInfoBean;

import java.util.List;

/**
 * Created by renxl
 * On 2017/4/21 18:39.
 */

class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ViewHolder> {

    private List<ArticleInfoBean> mDatas;

    ArticleListAdapter(List<ArticleInfoBean> datas) {
        mDatas = datas;
    }

    public void setData(List<ArticleInfoBean> datas) {
        if (datas == null && datas.size() <= 0) return;
        int len = mDatas.size();
        mDatas.clear();
        notifyItemRangeRemoved(0, len);
        mDatas.addAll(datas);
        notifyItemChanged(0, mDatas.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, null, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mDatas.get(position) != null && !TextUtils.isEmpty(mDatas.get(position).getArticle_title()))
            holder.tvTitle.setText(mDatas.get(position).getArticle_title());
        else
            holder.tvTitle.setText("---");
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_articles_article_title);
        }
    }
}
