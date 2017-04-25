package com.team.zhuoke.masterhelper.fragment.marster;

import com.team.zhuoke.masterhelper.api.NetWorkApi;
import com.team.zhuoke.masterhelper.fragment.ArticleInfoBean;
import com.team.zhuoke.masterhelper.fragment.BaseBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by renxl
 * On 2017/4/24 16:08.
 */

interface ArticleListService {
    @GET(NetWorkApi.masterArticle)
    Observable<BaseBean<ArticleInfoBean>> getArticleList(@Query("uid") String uid, @Query("pageCount") int pageCount);
}
