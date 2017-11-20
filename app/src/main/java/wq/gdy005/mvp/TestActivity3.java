package wq.gdy005.mvp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.base.BaseActivity;
import com.team.zhuoke.masterhelper.base.BaseView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by WangQing on 2016/12/9.
 */

public class TestActivity3 extends BaseActivity<Test3Model, Test3Presenter> implements Test3Contract.View {
    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.btn_home)
    Button btnHome;

    @Override
    public void setData(String s) {

        editText.setText(s);
    }

    @Override
    public void setErrorInfo(String message) {
        editText.setText(message);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test3;
    }

    @Override
    protected void onInitView(Bundle bundle) {

    }

    @Override
    protected void onEvent() {

    }

    @Override
    protected BaseView getView() {
        return this;
    }


    @OnClick(R.id.btn_home)
    public void onClick() {
        mPresenter.getTestList();
    }
}
