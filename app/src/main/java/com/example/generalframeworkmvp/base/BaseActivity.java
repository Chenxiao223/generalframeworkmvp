package com.example.generalframeworkmvp.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getlayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
    }

    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * 设置布局
     */
    public abstract int getlayoutId();

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    public void initImmersionBar(View view) {
        ImmersionBar.with(this)
                .statusBarView(view)
                .autoDarkModeEnable(true)
                .init();
    }
}
