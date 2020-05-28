package com.example.generalframeworkmvp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.generalframeworkmvp.R;
import com.example.generalframeworkmvp.base.BaseMvpActivity;
import com.example.generalframeworkmvp.bean.BaseObjectBean;
import com.example.generalframeworkmvp.bean.LoginBean;
import com.example.generalframeworkmvp.contract.MainContract;
import com.example.generalframeworkmvp.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import me.leefeng.promptlibrary.PromptDialog;

public class LoginActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {
    @BindView(R.id.view)
    View view;
    @BindView(R.id.et_name)
    EditText et_name;
    @BindView(R.id.et_pwd)
    EditText et_pwd;

    public PromptDialog promptDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        initImmersionBar(view);
        promptDialog = new PromptDialog(this);
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public int getlayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onSuccess(BaseObjectBean<LoginBean> bean) {
//        Toast.makeText(this, bean.getErrorMsg(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void showLoading() {
        promptDialog.showLoading("正在登陆");
    }

    @Override
    public void hideLoading() {
        promptDialog.dismiss();
    }

    @Override
    public void onError(Throwable throwable) {

    }

    /**
     * @return 帐号
     */
    private String getUsername() {
        return et_name.getText().toString().trim();
    }

    /**
     * @return 密码
     */
    private String getPassword() {
        return et_pwd.getText().toString().trim();
    }

    @OnClick(R.id.btn_login)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (getUsername().isEmpty() || getPassword().isEmpty()) {
                    Toast.makeText(this, "帐号密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                mPresenter.login(getUsername(), getPassword());
                break;
        }
    }
}
