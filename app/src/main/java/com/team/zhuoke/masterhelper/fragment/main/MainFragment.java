package com.team.zhuoke.masterhelper.fragment.main;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
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
import android.widget.TextView;
import android.widget.Toast;

import com.team.zhuoke.masterhelper.AboutUsActivity;
import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.fragment.BaseMainFragment;
import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.contextmenu.lib.MenuObject;
import com.yalantis.contextmenu.lib.MenuParams;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainFragment extends BaseMainFragment implements MainFragmentContract.IMainFragmentView, OnMenuItemClickListener {

    @InjectView(R.id.main_fragment_tb_bar)
    Toolbar mToolBar;
    @InjectView(R.id.main_fragment_tb_bar_container)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @InjectView(R.id.main_fragment_tb_bar_header_layout)
    AppBarLayout mAppBarLayout;
    @InjectView(R.id.main_fragment_rv_horizontal)
    RecyclerView mHorizontalRecycleView;
    @InjectView(R.id.main_fragment_rv_vertical)
    RecyclerView mVerticalRecycleView;

    private FragmentManager fragmentManager;
    private ContextMenuDialogFragment mMenuDialogFragment;

    private MainFragmentContract.IMainFragmentPresenter mPresenter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new MainFragmentPresenter(this);

        initActionBar();
        initMenuFragment();
        setHasOptionsMenu(true);
        initTitle(view);

        mPresenter.start();
    }

    private void initActionBar() {
        mActivity.setSupportActionBar(mToolBar);
        fragmentManager = getFragmentManager();
        ActionBar actionBar = mActivity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        mToolBar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        mToolBar.setNavigationOnClickListener(menu -> openDrawer());
    }

    private void initMenuFragment() {
        MenuParams menuParams = new MenuParams();
        menuParams.setActionBarSize((int) getResources().getDimension(R.dimen.tool_bar_height));
        menuParams.setMenuObjects(getMenuObjects());
        menuParams.setClosableOutside(false);
        mMenuDialogFragment = ContextMenuDialogFragment.newInstance(menuParams);
        mMenuDialogFragment.setItemClickListener(this);
    }

    private List<MenuObject> getMenuObjects() {
        // You can use any [resource, bitmap, drawable, color] as image:
        // item.setResource(...)
        // item.setBitmap(...)
        // item.setDrawable(...)
        // item.setColor(...)
        // You can set image ScaleType:
        // item.setScaleType(ScaleType.FIT_XY)
        // You can use any [resource, drawable, color] as background:
        // item.setBgResource(...)
        // item.setBgDrawable(...)
        // item.setBgColor(...)
        // You can use any [color] as text color:
        // item.setTextColor(...)
        // You can set any [color] as divider color:
        // item.setDividerColor(...)

        List<MenuObject> menuObjects = new ArrayList<>();

        MenuObject close = new MenuObject();
        close.setResource(R.drawable.icn_close);

        MenuObject send = new MenuObject("Send message");
        send.setResource(R.drawable.icn_1);

        MenuObject like = new MenuObject("Like profile");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.icn_2);
        like.setBitmap(b);

        MenuObject addFr = new MenuObject("Add to friends");
        BitmapDrawable bd = new BitmapDrawable(getResources(),
                BitmapFactory.decodeResource(getResources(), R.drawable.icn_3));
        addFr.setDrawable(bd);


        MenuObject addFav = new MenuObject("Add to favorites");
        addFav.setResource(R.drawable.icn_4);

        MenuObject aboutUs = new MenuObject("关于我们");
        BitmapDrawable aboutUsBD = new BitmapDrawable(getResources(),
                BitmapFactory.decodeResource(getResources(), R.drawable.icn_3));
        aboutUs.setDrawable(aboutUsBD);

        MenuObject block = new MenuObject("Block user");
        block.setResource(R.drawable.icn_5);

        menuObjects.add(close);
        menuObjects.add(send);
        menuObjects.add(like);
        menuObjects.add(addFr);
        menuObjects.add(addFav);
        menuObjects.add(aboutUs);
        menuObjects.add(block);
        return menuObjects;
    }

    private void initTitle(View view) {
        TextView mToolBarTextView = (TextView) view.findViewById(R.id.text_view_toolbar_title);
        mToolBarTextView.setText("主页");
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
                mMenuDialogFragment.show(fragmentManager, "ContextMenuDialogFragment");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
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

    @Override
    public void onMenuItemClick(View clickedView, int position) {

        // TODO: 2016/11/28  这里只是一个示范，可以优化
        switch (position) {
            case 5:
                //启动到关于我们的界面
                startActivity(new Intent(getContext(), AboutUsActivity.class));
                break;
        }


        Toast.makeText(mActivity, "酷 -> " + position, Toast.LENGTH_SHORT).show();
    }

}
