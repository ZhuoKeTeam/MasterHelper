package com.team.zhuoke.masterhelper.fragment.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kutear on 16-11-23.
 */

public class MainFragmentModel implements MainFragmentContract.IMainFragmentModel {
    @Override
    public void getHData(MainFragmentPresenter.CallBack<List<MainFragmentPresenter.HData>> callBack) {
        List<List<MainFragmentPresenter.HData>> result = new ArrayList<>();
        List<MainFragmentPresenter.HData> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add(new MainFragmentPresenter.HData());
        }
        result.add(dataList);
        callBack.getSuccess(result);
    }

    @Override
    public void getVData(MainFragmentPresenter.CallBack<MainFragmentPresenter.VData> callBack) {
        List<MainFragmentPresenter.VData> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add(new MainFragmentPresenter.VData());
        }
        callBack.getSuccess(dataList);
    }
}
