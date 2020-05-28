package com.example.generalframeworkmvp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.generalframeworkmvp.R;
import com.example.generalframeworkmvp.base.BaseFragment;

public class MyWorkOrderFragment extends BaseFragment {

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_work_order;
    }

    @Override
    public void initImmersionBar() {
        statusBarConfig().titleBar(R.id.title).init();
    }
}
