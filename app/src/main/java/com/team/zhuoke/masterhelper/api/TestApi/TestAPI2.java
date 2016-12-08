package com.team.zhuoke.masterhelper.api.TestApi;

import com.team.zhuoke.masterhelper.api.NetWorkApi;
import com.team.zhuoke.masterhelper.model.test.TestList;
import com.team.zhuoke.masterhelper.net.response.HttpResponse;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by WangQing on 2016/12/7.
 */

public interface TestAPI2 {

    @GET(NetWorkApi.getTestList)
    Observable<HttpResponse<List<TestList>>> getTestList();
}
