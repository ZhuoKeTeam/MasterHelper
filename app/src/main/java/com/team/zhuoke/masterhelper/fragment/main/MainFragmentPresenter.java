package com.team.zhuoke.masterhelper.fragment.main;

import android.view.ViewGroup;

import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.utils.adapter.CommonHeaderAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kutear on 16-11-23.
 */

class MainFragmentPresenter implements MainFragmentContract.IMainFragmentPresenter {
    private MainFragmentContract.IMainFragmentView mView;
    private MainFragmentContract.IMainFragmentModel mModel;
    private MainAdapter mAdapter;

    MainFragmentPresenter(MainFragmentContract.IMainFragmentView view) {
        this.mView = view;
        this.mModel = new MainFragmentModel();
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        mAdapter = new MainAdapter(new ArrayList<>());
        mModel.getVData(dataList -> {
            mAdapter.setNormal(dataList, false);
            mAdapter.notifyDataSetChanged();
        });

        mModel.getHData(new CallBack<List<HData>>() {
            @Override
            public void getSuccess(List<List<HData>> dataList) {
                mAdapter.setHeader(dataList, false);
                mAdapter.notifyDataSetChanged();
            }
        });
        mView.setTitle("主页");
        mView.setAdapter(mAdapter);
    }

    public static class HData {
        public int resImg = R.drawable.photo;

    }

    public static class VData {
        public int resImg = R.drawable.photo;

    }

    public interface CallBack<T> {
        void getSuccess(List<T> dataList);
    }

    private class MainAdapter extends CommonHeaderAdapter<List<HData>, VData> {


        public MainAdapter(List<VData> vDatas) {
            super(vDatas);
        }


        @Override
        protected BaseHolder onCreateHeaderVH(ViewGroup parent, int viewType) {
            return mView.getHeaderItem();
        }

        @Override
        protected BaseHolder onCreateNormalVH(ViewGroup parent, int viewType) {
            return mView.getVItem();
        }
    }


}
