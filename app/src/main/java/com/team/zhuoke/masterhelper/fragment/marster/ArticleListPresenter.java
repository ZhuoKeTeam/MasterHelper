package com.team.zhuoke.masterhelper.fragment.marster;

import com.team.zhuoke.masterhelper.fragment.ArticleInfoBean;
import com.team.zhuoke.masterhelper.fragment.BaseBean;
import com.team.zhuoke.masterhelper.utils.L;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by renxl
 * On 2017/4/21 17:39.
 */

class ArticleListPresenter extends ArticleListContract.IArticleListPresenter {

    private ArticleListContract.IArticleListView mArticleListView;

    ArticleListPresenter(ArticleListContract.IArticleListView articleListView) {
        mArticleListView = articleListView;
    }

    @Override
    public void getArticleDatas(String uid, int pageCount) {
        ArticleModel.getArticleDatas().getArticleList(uid, 5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseBean<ArticleInfoBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        L.d(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseBean<ArticleInfoBean> articleInfoBeanBaseBean) {

                        L.d("renxl", articleInfoBeanBaseBean.toString());

                        mArticleListView.setData(articleInfoBeanBaseBean.getResult());
                    }
                });
    }
}
