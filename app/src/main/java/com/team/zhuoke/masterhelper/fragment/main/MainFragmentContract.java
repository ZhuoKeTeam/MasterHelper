package com.team.zhuoke.masterhelper.fragment.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by kutear on 16-11-23.
 */

interface MainFragmentContract {
    interface IMainFragmentView {
        void setTitle(String title);

        void setPresenter(IMainFragmentPresenter presenter);

        View getVItem();

        View getHItem();

        void setHAdapter(RecyclerView.Adapter<MainFragment.HHolder> adapter);

        void setVAdapter(RecyclerView.Adapter<MainFragment.VHolder> adapter);
    }

    interface IMainFragmentModel {
        void getHData(MainFragmentPresenter.CallBack<MainFragmentPresenter.HData> callBack);

        void getVData(MainFragmentPresenter.CallBack<MainFragmentPresenter.VData> callBack);
    }

    interface IMainFragmentPresenter {
        void start();
    }

}
