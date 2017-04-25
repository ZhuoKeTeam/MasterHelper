package com.team.zhuoke.masterhelper.fragment.marster;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.base.BaseView;
import com.team.zhuoke.masterhelper.fragment.MasterInfoBean;
import com.team.zhuoke.masterhelper.utils.backfragmentutils.BackFragment;
import com.yalantis.euclid.library.EuclidFragment;
import com.yalantis.euclid.library.EuclidListAdapter;
import com.yalantis.euclid.library.EuclidState;

import java.util.List;

/**
 * Created by Doraemon on 2016/11/29.
 * 继承EuclidFragment 实现效果
 * 还未修改成MVP模式
 */

public class EuclidChildFragment extends EuclidFragment<MasterModel, MasterPresenter> implements BackFragment, MasterContract.View {
    private FragmentManager fm;
    private ArticleListFragment articleListFragment;
    private ToolBarBackClickLister toolBarBackClickLister;
    private EuclidListAdapter adapter;

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void onInitView(Bundle bundle) {

    }

    @Override
    protected void onEvent() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFramlayout();
    }

    private void initFramlayout() {
        fm = getChildFragmentManager();
        articleListFragment = new ArticleListFragment();
        fm.beginTransaction().add(R.id.layout_article_list, articleListFragment).commit();
    }

    @Override
    public void initList(MasterInfoBean masterInfoBean) {
        if (articleListFragment != null) {
            articleListFragment.init(masterInfoBean.getUid());
        }
    }

    @Override
    protected BaseView getViewImp() {
        return this;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (mPresenter != null)
            mPresenter.getMasterList();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButtonProfile.setOnClickListener(v -> Toast.makeText(getActivity(), "Oh hi!", Toast.LENGTH_SHORT).show());
        mToolbarBack.setImageResource(R.drawable.ic_menu_white_24dp);
        mToolbarBack.setScaleType(ImageView.ScaleType.CENTER);
        mTextViewBio.setOnClickListener(v -> {
                    mList.setVisibility(View.GONE);
                    mListView.setVisibility(View.VISIBLE);
                    mContentLayout.setVisibility(View.VISIBLE);
                    if (mOverlayListItemView != null) {
                        mOverlayListItemView.setVisibility(View.VISIBLE);
                    }
                }
        );
        mTextViewList.setOnClickListener(v -> {
                    mList.setVisibility(View.VISIBLE);
                    mListView.setVisibility(View.GONE);
                    mContentLayout.setVisibility(View.GONE);
                    if (mOverlayListItemView != null) {
                        mOverlayListItemView.setVisibility(View.GONE);
                    }
                }
        );
        mToolbarBack.setOnClickListener(view1 -> {
            if (toolBarBackClickLister != null) {
                toolBarBackClickLister.onBackClick();
            }
        });
        setTitle("大神");

        mPresenter.getMasterList();
    }

    @Override
    protected BaseAdapter getAdapter() {
        adapter = new EuclidListAdapter(getContext(), null);
        return adapter;
    }

    public void setToolBarBackClickLister(ToolBarBackClickLister toolBarBackClickLister) {
        this.toolBarBackClickLister = toolBarBackClickLister;
    }

    @Override
    public boolean onBackPressed() {
        if (getState() != EuclidState.Closed) {
            mList.setVisibility(View.GONE);
            mListView.setVisibility(View.VISIBLE);
            mContentLayout.setVisibility(View.VISIBLE);
            if (mOverlayListItemView != null) {
                mOverlayListItemView.setVisibility(View.VISIBLE);
            }
            animateCloseProfileDetails();
            return true;
        }
        return false;
    }

    @Override
    public int getBackPriority() {
        return 0;
    }

    @Override
    public void setData(List<MasterInfoBean> masterInfoBeanList) {
        adapter.setData(masterInfoBeanList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setErrorInfo(String message) {

    }

    /**
     * 返回键监听
     */
    interface ToolBarBackClickLister {
        void onBackClick();
    }
}
