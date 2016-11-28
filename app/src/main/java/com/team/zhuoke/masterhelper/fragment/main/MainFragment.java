package com.team.zhuoke.masterhelper.fragment.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.team.zhuoke.masterhelper.AboutUsActivity;
import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.fragment.BaseMainFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainFragment extends BaseMainFragment implements MainFragmentContract.IMainFragmentView {

    @BindView(R.id.main_fragment_tb_bar)
    Toolbar mToolBar;
    @BindView(R.id.main_fragment_tb_bar_container)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.main_fragment_tb_bar_header_layout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.main_fragment_rv_horizontal)
    RecyclerView mHorizontalRecycleView;
    @BindView(R.id.main_fragment_rv_vertical)
    RecyclerView mVerticalRecycleView;

    private MainFragmentContract.IMainFragmentPresenter mPresenter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new MainFragmentPresenter(this);
        mActivity.setSupportActionBar(mToolBar);
        mToolBar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        mToolBar.setNavigationOnClickListener(menu -> openDrawer());
        setHasOptionsMenu(true);


        mPresenter.start();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_menu:
                Toast.makeText(mActivity, "菜单", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), AboutUsActivity.class));
                break;
        }
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.reset(this);
    }

    @Override
    public void setTitle(String title) {
        mActivity.getSupportActionBar()
                .setTitle(title);
    }

    @Override
    public void setPresenter(MainFragmentContract.IMainFragmentPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public View getVItem() {
        return mActivity.getLayoutInflater().inflate(R.layout.fragment_v_recycle_item, mVerticalRecycleView, false);
    }

    @Override
    public View getHItem() {
        return mActivity.getLayoutInflater().inflate(R.layout.fragment_h_recycle_item, mHorizontalRecycleView, false);
    }

    @Override
    public void setHAdapter(RecyclerView.Adapter<HHolder> adapter) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mHorizontalRecycleView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(),
                DividerItemDecoration.HORIZONTAL);
        mHorizontalRecycleView.addItemDecoration(decoration);
        mHorizontalRecycleView.setAdapter(adapter);
    }

    @Override
    public void setVAdapter(RecyclerView.Adapter<VHolder> adapter) {
        mVerticalRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL);
        mVerticalRecycleView.setNestedScrollingEnabled(false);
        mVerticalRecycleView.addItemDecoration(decoration);
        mVerticalRecycleView.setAdapter(adapter);
    }


    public static class VHolder extends RecyclerView.ViewHolder {
        private ImageView innerImage;
        private View innerContainer;

        VHolder(View itemView) {
            super(itemView);
            this.innerContainer = itemView;
            innerImage = (ImageView) itemView.findViewById(R.id.main_fragment_v_recycle_item_img);
        }

        void bindData(MainFragmentPresenter.VData data) {
            innerImage.setImageResource(data.resImg);
            innerContainer.setOnClickListener(view ->
                    Toast.makeText(view.getContext(), "竖向Item被点", Toast.LENGTH_SHORT).show());
        }
    }

    public static class HHolder extends RecyclerView.ViewHolder {
        private ImageView innerImage;
        private View innerContainer;

        HHolder(View itemView) {
            super(itemView);
            this.innerContainer = itemView;
            innerImage = (ImageView) itemView.findViewById(R.id.main_fragment_h_recycle_item_img);
        }

        void bindData(MainFragmentPresenter.HData data) {
            innerImage.setImageResource(data.resImg);
            innerContainer.setOnClickListener(view ->
                    Toast.makeText(view.getContext(), "横向Item被点", Toast.LENGTH_SHORT).show());
        }
    }
}
