//package com.team.zhuoke.masterhelper.model.test;
//
//import android.content.Context;
//
//import com.team.zhuoke.masterhelper.api.TestApi.TestApi;
//import com.team.zhuoke.masterhelper.net.http.HttpUtils;
//import com.team.zhuoke.masterhelper.net.transformer.DefaultTransformer;
//import com.team.zhuoke.masterhelper.presenter.test.interfaces.MasterListContract;
//
//import java.util.List;
//
//import rx.Observable;
//
///**
// * 作者：${User}
// * 电话：18810474975
// * 邮箱：18810474975@163.com
// * 版本号：
// * 类描述：  业务逻辑处理类
// * 修改时间：${DATA}1058
// */
//
//public class MasterListModel implements MasterListContract.Model{
//
//    /**
//     *  获取 MasterList
//     * @param context
//     * @return
//     */
//    @Override
//    public Observable<List<MasterList>> MasterList(Context context) {
//        return  HttpUtils.getInstance(context)
//                .setLoadDiskCache(false)
//                .setLoadMemoryCache(false)
//                .getRetofitClinet()
//                .builder(TestApi.class)
//                .getMasterList()
////               进行预处理
//                .compose(new DefaultTransformer<List<MasterList>>());
//    }
//
//
//}
