package com.team.zhuoke.masterhelper.view.test.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.ImageLoader;
import com.facebook.fresco.helper.Phoenix;
import com.facebook.fresco.helper.utils.DensityUtil;
import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.base.BaseActivity;
import com.team.zhuoke.masterhelper.base.BaseView;
import com.team.zhuoke.masterhelper.model.test.FrescoModel;
import com.team.zhuoke.masterhelper.model.test.FrescoView;
import com.team.zhuoke.masterhelper.presenter.test.imp.FrescoPresenter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TestFresco2Activity extends BaseActivity<FrescoModel, FrescoPresenter> implements FrescoView {

    @InjectView(R.id.sdv_1)
    SimpleDraweeView mFrescoView1;
    @InjectView(R.id.sdv_2)
    SimpleDraweeView mFrescoView2;
    @InjectView(R.id.sdv_3)
    SimpleDraweeView mFrescoView3;
    @InjectView(R.id.sdv_4)
    SimpleDraweeView mFrescoView4;
    @InjectView(R.id.sdv_5)
    SimpleDraweeView mFrescoView5;
    @InjectView(R.id.sdv_6)
    SimpleDraweeView mFrescoView6;
    @InjectView(R.id.sdv_7)
    SimpleDraweeView mFrescoView7;
    @InjectView(R.id.sdv_8)
    SimpleDraweeView mFrescoView8;
    @InjectView(R.id.sdv_9)
    SimpleDraweeView mFrescoView9;
    @InjectView(R.id.sdv_10)
    SimpleDraweeView mFrescoView10;
    @InjectView(R.id.sdv_11)
    SimpleDraweeView mFrescoView11;
    @InjectView(R.id.sdv_12)
    SimpleDraweeView mFrescoView12;
    @InjectView(R.id.sdv_13)
    SimpleDraweeView mFrescoView13;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test_fresco_2;
    }

    @Override
    protected void onInitView(Bundle bundle) {
        mPresenter.getGirlList();
    }

    @Override
    protected void onEvent() {

    }

    @Override
    protected BaseView getView() {
        return this;
    }

    @Override
    public void setData(List<String> girlList) {
        String url = "http://ww3.sinaimg.cn/large/610dc034jw1f6m4aj83g9j20zk1hcww3.jpg";

//        Phoenix.with(mFrescoView1).load(url);
        //  正常网络加载一张图片
        ImageLoader.loadImage(mFrescoView1, url);

        // 网络加载一张图片，并以圆形显示
        ImageLoader.loadImage(mFrescoView2, url);

        // 网络加载一张图片，并以圆形加边框显示
        ImageLoader.loadImage(mFrescoView3, url);

        // 网络加载一张图片，四周圆角
        ImageLoader.loadImage(mFrescoView4, url);

        // 网络加载一张图片，某几边带圆角
        ImageLoader.loadImage(mFrescoView5, url);

        // 网络加载一张图片，某几边带圆角
        ImageLoader.loadImage(mFrescoView6, url);

        // 网络加载一张图片，带占位图 但是并没有实际的链接
        ImageLoader.loadImage(mFrescoView7, "");

        // 网络加载一张图片，带占位图 并有渐进时间
        ImageLoader.loadImage(mFrescoView8, url);

        // 网络加载一张图片，点击变色并且可以有点击事件
        ImageLoader.loadImage(mFrescoView9, url);
        if (mFrescoView9 != null) {
            mFrescoView9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(TestFresco2Activity.this, "谁谁谁", Toast.LENGTH_SHORT).show();
                }
            });
        }

        //  网络加载一张图片，但是设置了覆盖图片
        ImageLoader.loadImage(mFrescoView10, url);

        //  网络加载一张图片，但是链接是有问题的，所以设置了点击再次请求图片，最多点四次
        //  且有进度动画，最后还是失败了会显示预设的失败图片
        String url2 = "http://www.baidu.com";
        ImageLoader.loadImage(mFrescoView11, url2);

        //  显示Gif
        String gif = "http://img4.178.com/acg1/201506/227753817857/227754566617.gif";
        ImageLoader.loadImage(mFrescoView12, gif);

        //  高斯模糊的图片
        mFrescoView13.setAspectRatio(0.7f);
        ImageLoader.loadImageBlur(mFrescoView13, girlList.get(0));

    }

    @Override
    public void setErrorInfo(String message) {

    }

}
