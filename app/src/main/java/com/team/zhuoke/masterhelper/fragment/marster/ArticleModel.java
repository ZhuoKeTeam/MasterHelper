package com.team.zhuoke.masterhelper.fragment.marster;

import com.team.zhuoke.masterhelper.api.NetWorkApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by renxl
 * On 2017/4/21 18:43.
 */

class ArticleModel {

    static ArticleListService getArticleDatas() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetWorkApi.newBaseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ArticleListService.class);
    }
}
