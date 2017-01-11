package com.team.zhuoke.masterhelper.view.test.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.ImageLoader;
import com.facebook.fresco.helper.Phoenix;
import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.base.BaseActivity;
import com.team.zhuoke.masterhelper.base.BaseView;
import com.team.zhuoke.masterhelper.model.test.FrescoModel;
import com.team.zhuoke.masterhelper.model.test.FrescoView;
import com.team.zhuoke.masterhelper.presenter.test.imp.FrescoPresenter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TestFrescoActivity extends BaseActivity<FrescoModel, FrescoPresenter> implements FrescoView {
    private static final String TAG = "TestFrescoActivity";
    @InjectView(R.id.rv_girl_list)
    RecyclerView mGirlListView;
    private List<String> mGirlList;
    private GirlListAdapter mAdapter;

    @Override
    public void setData(List<String> girlList) {
        mGirlList = girlList;
        mAdapter.notifyDataSetChanged();
        Log.e(TAG, "setData");
    }

    @Override
    public void setErrorInfo(String message) {
        Log.e(TAG, "setErrorInfo");
    }

    @Override
    protected int getLayoutId() {
        Log.e(TAG, "getLayoutId");
        return R.layout.activity_test_fresco;
    }

    @Override
    protected void onInitView(Bundle bundle) {
        Log.e(TAG, "onInitView");
        mGirlListView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new GirlListAdapter();
        mGirlListView.setAdapter(mAdapter);
        mPresenter.getGirlList();
    }

    @Override
    protected void onEvent() {
        Log.e(TAG, "onEvent");
    }

    @Override
    protected BaseView getView() {
        Log.e(TAG, "getView");
        return this;
    }

    class GirlListAdapter extends RecyclerView.Adapter<GirlHolder> {

        @Override
        public GirlHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show_girl_by_card, parent, false);
            return new GirlHolder(view);
        }

        @Override
        public void onBindViewHolder(GirlHolder holder, int position) {
            holder.setDate(position);
        }

        @Override
        public int getItemCount() {
            return mGirlList != null ? mGirlList.size() : 0;
        }

    }

    class GirlHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.sdv_girl)
        SimpleDraweeView showGirl;
        @InjectView(R.id.tv_girl_describe)
        TextView showGirlDescribe;

        public GirlHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }

        public void setDate(int position) {
            switch (position) {
                case 0:
                    Phoenix.with(showGirl).load(mGirlList.get(position));
                    break;
                case 1:
                    ImageLoader.loadImage(showGirl, mGirlList.get(position));
                    break;
                case 2:
                    ImageLoader.loadImage(showGirl, mGirlList.get(position));
                    break;
                case 3:
                    ImageLoader.loadImage(showGirl, mGirlList.get(position));
                    break;
                case 4:
                    ImageLoader.loadImage(showGirl, mGirlList.get(position));
                    break;
                case 5:
                    ImageLoader.loadImage(showGirl, mGirlList.get(position));
                    break;
                case 6:
                    ImageLoader.loadImage(showGirl, mGirlList.get(position));
                    break;
                case 7:
                    ImageLoader.loadImage(showGirl, mGirlList.get(position));
                    break;
                case 8:
                    ImageLoader.loadImage(showGirl, mGirlList.get(position));
                    break;
                case 9:
                    ImageLoader.loadImage(showGirl, mGirlList.get(position));
                    break;
                case 10:
                    ImageLoader.loadImage(showGirl, mGirlList.get(position));
                    break;
                case 11:
                    ImageLoader.loadImage(showGirl, mGirlList.get(position));
                    break;
                case 12:
                    ImageLoader.loadImage(showGirl, mGirlList.get(position));
                    break;
                case 13:
                    ImageLoader.loadImage(showGirl, mGirlList.get(position));
                    break;
                case 14:
                    ImageLoader.loadImage(showGirl, mGirlList.get(position));
                    break;
            }
            showGirlDescribe.setText("妹子~~~~" + position);
        }
    }
}
