package com.team.zhuoke.masterhelper.fragment.marster;

import com.team.zhuoke.masterhelper.base.BaseView;
import com.team.zhuoke.masterhelper.fragment.ArticleInfoBean;

import java.util.List;

/**
 * Created by renxl
 * On 2017/4/21 18:45.
 */

interface ArticleListContract {
    interface IArticleListView extends BaseView {
        void setData(List<ArticleInfoBean> datas);

        void refresh(List<ArticleInfoBean> datas);
    }

    abstract class IArticleListPresenter {
        abstract void getArticleDatas(String uid, int pageCount);
    }
}
