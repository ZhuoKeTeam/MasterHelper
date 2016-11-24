package com.team.zhuoke.masterhelper.fragment.main;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.team.zhuoke.masterhelper.R;

import java.util.List;

/**
 * Created by kutear on 16-11-23.
 */

class MainFragmentPresenter implements MainFragmentContract.IMainFragmentPresenter {
    private MainFragmentContract.IMainFragmentView mView;
    private MainFragmentContract.IMainFragmentModel mModel;

    MainFragmentPresenter(MainFragmentContract.IMainFragmentView view) {
        this.mView = view;
        this.mModel = new MainFragmentModel();
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        mModel.getHData(new CallBack<HData>() {
            @Override
            public void getSuccess(List<HData> dataList) {
                mView.setHAdapter(new HAdapter(dataList));
            }
        });

        mModel.getVData(new CallBack<VData>() {
            @Override
            public void getSuccess(List<VData> dataList) {
                mView.setVAdapter(new VAdapter(dataList));
            }
        });

        mView.setTitle("主页");
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

    private class HAdapter extends RecyclerView.Adapter<MainFragment.HHolder> {
        private List<HData> innerDataList;

        HAdapter(List<HData> dataList) {
            this.innerDataList = dataList;
        }

        @Override
        public MainFragment.HHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MainFragment.HHolder(mView.getHItem());
        }

        @Override
        public void onBindViewHolder(MainFragment.HHolder holder, int position) {
            holder.bindData(innerDataList.get(position));
        }

        @Override
        public int getItemCount() {
            return innerDataList.size();
        }
    }

    private class VAdapter extends RecyclerView.Adapter<MainFragment.VHolder> {
        private List<VData> innerDataList;

        VAdapter(List<VData> dataList) {
            this.innerDataList = dataList;
        }

        @Override
        public MainFragment.VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MainFragment.VHolder(mView.getVItem());
        }

        @Override
        public void onBindViewHolder(MainFragment.VHolder holder, int position) {
            holder.bindData(innerDataList.get(position));
        }

        @Override
        public int getItemCount() {
            return innerDataList.size();
        }
    }


}
