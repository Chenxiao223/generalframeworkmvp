package com.example.generalframeworkmvp.fragment;

import android.view.View;

import com.example.generalframeworkmvp.R;
import com.example.generalframeworkmvp.base.BaseMvpFragment;
import com.example.generalframeworkmvp.bean.BaseObjectBean;
import com.example.generalframeworkmvp.bean.LoginBean;
import com.example.generalframeworkmvp.contract.MainContract;
import com.example.generalframeworkmvp.presenter.MainPresenter;
import com.uber.autodispose.AutoDisposeConverter;

public class HomeFragment extends BaseMvpFragment<MainPresenter> implements MainContract.View {

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initImmersionBar() {
        statusBarConfig().titleBar(R.id.title).init();
    }

    @Override
    public void onSuccess(BaseObjectBean<LoginBean> bean) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public <T> AutoDisposeConverter<T> bindAutoDispose() {
        return null;
    }
}
