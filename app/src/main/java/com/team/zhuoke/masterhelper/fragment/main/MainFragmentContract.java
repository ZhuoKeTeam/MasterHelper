package com.team.zhuoke.masterhelper.fragment.main;

import android.support.v7.widget.RecyclerView;

import com.team.zhuoke.masterhelper.utils.adapter.BaseAdapter;

import java.util.List;

/**
 * Created by kutear on 16-11-23.
 */

interface MainFragmentContract {
    interface IMainFragmentView {
        void setTitle(String title);

        void setPresenter(IMainFragmentPresenter presenter);

        BaseAdapter.BaseHolder getVItem();

        BaseAdapter.BaseHolder getHeaderItem();

        void setAdapter(RecyclerView.Adapter adapter);
    }

    interface IMainFragmentModel {
        void getHData(MainFragmentPresenter.CallBack<List<MainFragmentPresenter.HData>> callBack);

        void getVData(MainFragmentPresenter.CallBack<MainFragmentPresenter.VData> callBack);
    }

    interface IMainFragmentPresenter {
        void start();
    }

}
