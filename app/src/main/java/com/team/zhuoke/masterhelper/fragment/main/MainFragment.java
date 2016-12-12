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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.team.zhuoke.masterhelper.AboutUsActivity;
import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.bean.MasterInfoBean;
import com.team.zhuoke.masterhelper.fragment.BaseMainFragment;
import com.team.zhuoke.masterhelper.utils.adapter.BaseAdapter;
import com.team.zhuoke.masterhelper.utils.adapter.CommonAdapter;
import com.team.zhuoke.masterhelper.view.test.activity.TestActivity2;
import com.team.zhuoke.masterhelper.view.test.activity.TestFresco2Activity;
import com.team.zhuoke.masterhelper.view.test.activity.TestFrescoActivity;
import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.contextmenu.lib.MenuObject;
import com.yalantis.contextmenu.lib.MenuParams;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemClickListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;
import wq.gdy005.mvp.TestActivity3;

public class MainFragment extends BaseMainFragment implements MainFragmentContract.IMainFragmentView, OnMenuItemClickListener {

    private static final String TAG = "MainFragment";

    @InjectView(R.id.main_fragment_tb_bar)
    Toolbar mToolBar;
    @InjectView(R.id.main_fragment_tb_bar_container)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @InjectView(R.id.main_fragment_tb_bar_header_layout)
    AppBarLayout mAppBarLayout;
    @InjectView(R.id.main_fragment_rv_vertical)
    RecyclerView mVerticalRecycleView;
    @InjectView(R.id.text_view_toolbar_title)
    TextView mToolBarTextView;


    private FragmentManager fragmentManager;
    private ContextMenuDialogFragment mMenuDialogFragment;

    private MainFragmentContract.IMainFragmentPresenter mPresenter;

    public static MainFragment getInstance() {
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

        String url = "https://zkteam.wilddogio.com/master_list.json";
        RequestCall requestCall = OkHttpUtils.get().url(url).build();
        requestCall.execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.d(TAG, "onError() called with: call = [" + call + "], e = [" + e + "], id = [" + id + "]");
            }

            @Override
            public void onResponse(String response, int id) {
                Log.d(TAG, "onResponse() called with: response = [" + response + "], id = [" + id + "]");

                Gson gson = new Gson();
                MasterInfoBean masterInfoBean = gson.fromJson(response, MasterInfoBean.class);

                Log.i(TAG, "onResponse: " + masterInfoBean.toString());

                // TODO: 2016/11/29  这是测试的数据源。


            }
        });
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

        List<MenuObject> menuObjects = new ArrayList<>();

        MenuObject close = new MenuObject();
        close.setResource(R.drawable.icn_close);

        MenuObject send = new MenuObject("第三 MVP 界面");
        send.setResource(R.drawable.icn_1);

        MenuObject like = new MenuObject("Like profile");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.icn_2);
        like.setBitmap(b);

        MenuObject addFr = new MenuObject("Fresco_Demo_1");
        BitmapDrawable bd = new BitmapDrawable(getResources(),
                BitmapFactory.decodeResource(getResources(), R.drawable.icn_3));
        addFr.setDrawable(bd);


        MenuObject addFav = new MenuObject("Fresco_Demo_2");
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
        mToolBarTextView.setText(title);
    }

    @Override
    public void setPresenter(MainFragmentContract.IMainFragmentPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public BaseAdapter.BaseHolder getVItem() {
        View view = mActivity.getLayoutInflater().inflate(R.layout.fragment_v_recycle_item, mVerticalRecycleView, false);
        return new VHolder(view);
    }

    @Override
    public BaseAdapter.BaseHolder getHeaderItem() {
        View view = mActivity.getLayoutInflater().inflate(R.layout.fragment_h_recycle_item, mVerticalRecycleView, false);
        return new HHolder(view);
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        mVerticalRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL);
        mVerticalRecycleView.setNestedScrollingEnabled(false);
        mVerticalRecycleView.addItemDecoration(decoration);
        mVerticalRecycleView.setAdapter(adapter);
    }

    @Override
    public void onMenuItemClick(View clickedView, int position) {

        // TODO: 2016/11/28  这里只是一个示范，可以优化
        switch (position) {
            case 5:
                //启动到关于我们的界面
                startActivity(new Intent(getContext(), AboutUsActivity.class));
                break;
            case 4:
                //启动到 Fresco-helper 使用界面
                startActivity(new Intent(getContext(), TestFresco2Activity.class));
                break;
            case 3:
                //启动到 Fresco-helper 使用界面
                startActivity(new Intent(getContext(), TestFrescoActivity.class));
                break;
            case 1:
                //启动到 测试 MVP的界面
                startActivity(new Intent(getContext(), TestActivity3.class));
                break;
        }


        Toast.makeText(mActivity, "酷 -> " + position, Toast.LENGTH_SHORT).show();
    }

    public class VHolder extends BaseAdapter.BaseHolder<MainFragmentPresenter.VData> {

        public VHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onCover(View view, MainFragmentPresenter.VData data) {
            container.setOnClickListener(view1 -> Toast.makeText(view1.getContext(), "竖直方向", Toast.LENGTH_SHORT).show());
        }
    }

    public class HHolder extends BaseAdapter.BaseHolder<List<MainFragmentPresenter.HData>> {
        private RecyclerView headerRecycle;

        public HHolder(View itemView) {
            super(itemView);
            headerRecycle = (RecyclerView) itemView.findViewById(R.id.header_recycle);
        }

        @Override
        protected void onCover(View view, List<MainFragmentPresenter.HData> data) {

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            headerRecycle.setLayoutManager(linearLayoutManager);
            DividerItemDecoration decoration = new DividerItemDecoration(getContext(),
                    DividerItemDecoration.HORIZONTAL);
            headerRecycle.addItemDecoration(decoration);
            headerRecycle.setAdapter(new HeaderAdapter(data));
        }
    }

    public class HHolderItem extends BaseAdapter.BaseHolder<MainFragmentPresenter.HData> {


        public HHolderItem(View itemView) {
            super(itemView);
        }

        @Override
        protected void onCover(View view, MainFragmentPresenter.HData data) {
            container.setOnClickListener(view1 -> Toast.makeText(view1.getContext(), "水平方向", Toast.LENGTH_SHORT).show());
        }
    }

    public class HeaderAdapter extends CommonAdapter<MainFragmentPresenter.HData> {

        public HeaderAdapter(List<MainFragmentPresenter.HData> hDatas) {
            super(hDatas);
        }

        @Override
        protected BaseHolder onCreateNormalVH(ViewGroup parent, int viewType) {
            return getHeaderItemHolder();
        }
    }

    private BaseAdapter.BaseHolder getHeaderItemHolder() {
        View view = mActivity.getLayoutInflater().inflate(R.layout.fragment_v_recycle_item,
                mVerticalRecycleView, false);
        return new HHolderItem(view);
    }
}
