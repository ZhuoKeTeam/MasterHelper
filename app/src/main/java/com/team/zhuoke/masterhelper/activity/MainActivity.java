package com.team.zhuoke.masterhelper.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.fragment.BaseMainFragment;
import com.team.zhuoke.masterhelper.fragment.main.MainFragment;
import com.team.zhuoke.masterhelper.fragment.marster.ProfileFragment;
import com.team.zhuoke.masterhelper.utils.backfragmentutils.BackFragmentHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("RestrictedApi")
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BaseMainFragment.OnDrawerController {
    private static final String FRAGMENT_KEY = "_KEY";
    @BindView(R.id.main_fl_container)
    FrameLayout mFragment;
    @BindView(R.id.main_nv_menu)
    NavigationView mNavigationView;
    @BindView(R.id.main_dl_container)
    DrawerLayout mDrawerLayout;
    private FragmentManager mFragmentManager;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();
        initView();
        bindFragment(savedInstanceState);
    }

    private void initView() {
        mNavigationView.setNavigationItemSelectedListener(this);
//        mNavigationView.setCheckedItem(R.id.nav_home);
    }

    private void bindFragment(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Fragment fragment = mFragmentManager.findFragmentById(R.id.main_fl_container);
            if (fragment != null) {
                return;
            }
        }


        if (profileFragment == null) {
            profileFragment = new ProfileFragment();
        }

        mFragmentManager.beginTransaction()
                .add(R.id.main_fl_container, profileFragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (!onBackPressedWithResult()) {
            super.onBackPressed();
        }
    }

    public boolean onBackPressedWithResult() {
        return BackFragmentHelper.fireOnBackPressedEvent(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mNavigationView.setCheckedItem(item.getItemId());
        switch (item.getItemId()) {
//            // TODO: 16-11-23 侧面菜单点击
//            case R.id.nav_home:
//                if (!MainFragment.getInstance().isVisible()) {
//                    mFragmentManager.beginTransaction().show(MainFragment.getInstance()).hide(profileFragment).commit();
//                }
//                break;
            case R.id.nav_master:
                if (profileFragment == null) {
                    profileFragment = new ProfileFragment();
                }
                if (!profileFragment.isAdded()) {
                    mFragmentManager.beginTransaction()
                            .add(R.id.main_fl_container, profileFragment)
                            .commit();
                }
                if (!profileFragment.isVisible()) {
                    mFragmentManager.beginTransaction().show(profileFragment).hide(MainFragment.getInstance()).commit();
                }
                break;
        }
        closeDrawer();
        return true;
    }

    @Override
    public void openDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public void closeDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }
}
