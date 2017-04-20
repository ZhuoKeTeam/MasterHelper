package com.team.zhuoke.masterhelper.fragment.marster;

import com.team.zhuoke.masterhelper.api.NetWorkApi;
import com.team.zhuoke.masterhelper.fragment.MasterInfoBean;
import com.team.zhuoke.masterhelper.net.response.HttpResponse;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by WangQing on 2017/4/20.
 */
public interface MasterInfoApi {
    @GET(NetWorkApi.masterInfo)
    Observable<HttpResponse<List<MasterInfoBean>>> getMasterList();
}
