package com.team.zhuoke.masterhelper.api.TestApi;

import com.team.zhuoke.masterhelper.api.NetWorkApi;
import com.team.zhuoke.masterhelper.model.test.MasterList;
import com.team.zhuoke.masterhelper.net.response.HttpResponse;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * 作者：${User}
 * 电话：18810474975
 * 邮箱：18810474975@163.com
 * 版本号：
 * 类描述：
 * 修改时间：${DATA}1734
 */

public interface TestApi {

    @GET(NetWorkApi.getMasterList)
    Observable<HttpResponse<List<MasterList>>> getMasterList();
}
