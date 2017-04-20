package com.team.zhuoke.masterhelper.fragment.marster;

import android.content.Context;

import com.team.zhuoke.masterhelper.fragment.MasterInfoBean;
import com.team.zhuoke.masterhelper.net.http.HttpUtils;
import com.team.zhuoke.masterhelper.net.transformer.DefaultTransformer;

import java.util.List;

import rx.Observable;

/**
 * Created by WangQing on 2017/4/20.
 */
public class MasterModel implements MasterContract.Model {
    @Override
    public Observable<List<MasterInfoBean>> getMasterData(Context context) {

        String string =Thread.currentThread().getName();
        return  HttpUtils.getInstance(context)
                .setLoadDiskCache(false)
                .setLoadMemoryCache(false)
                .getRetofitClinet()
                .builder(MasterInfoApi.class)
                .getMasterList()
                .compose(new DefaultTransformer<>());
    }
}
