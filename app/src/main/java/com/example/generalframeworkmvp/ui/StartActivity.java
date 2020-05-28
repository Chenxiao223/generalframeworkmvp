package com.example.generalframeworkmvp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.generalframeworkmvp.R;
import com.example.generalframeworkmvp.base.BaseActivity;

import butterknife.BindView;

public class StartActivity extends BaseActivity {
    @BindView(R.id.view)
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        initImmersionBar(view);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(StartActivity.this, LoginActivity.class));
                finish();
            }
        }, 5000);
    }

    @Override
    public int getlayoutId() {
        return R.layout.activity_start;
    }
}
