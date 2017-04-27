package com.team.zhuoke.masterhelper.fragment.marster;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.activity.PageCtrl;
import com.team.zhuoke.masterhelper.fragment.ArticleInfoBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by renxl
 * On 2017/4/22 15:30.
 */

public class ArticleListFragment extends Fragment implements ArticleListContract.IArticleListView {

    @InjectView(R.id.recycleview_articles)
    RecyclerView recycleviewArticles;

    private ArticleListContract.IArticleListPresenter mArticleListPresenter;
    private ArticleListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articles, null, false);
        ButterKnife.inject(this, view);
        mArticleListPresenter = new ArticleListPresenter(this);
        return view;
    }

    public void init(String uid) {
        mArticleListPresenter.getArticleDatas(uid, 5);
    }

    @Override
    public void refresh(List<ArticleInfoBean> datas) {
        if (adapter != null) {
            adapter.setData(datas);
        }
    }

    @Override
    public void setData(List<ArticleInfoBean> datas) {
        if (datas == null || datas.size() <= 0)
            return;
        adapter = new ArticleListAdapter(datas);
        adapter.setOnItemClickListener(position -> {
            if (TextUtils.isEmpty(datas.get(position).getArticle_title()) || TextUtils.isEmpty(datas.get(position).getArticle_address()))
                return;
            PageCtrl.startArticleDetailActivity(getActivity(), datas.get(position).getArticle_address(), datas.get(position).getArticle_title());
        });
        recycleviewArticles.setAdapter(adapter);
        recycleviewArticles.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recycleviewArticles.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
