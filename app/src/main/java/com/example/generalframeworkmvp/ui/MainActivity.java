package com.example.generalframeworkmvp.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.generalframeworkmvp.R;
import com.example.generalframeworkmvp.base.BaseActivity;
import com.example.generalframeworkmvp.fragment.HomeFragment;
import com.example.generalframeworkmvp.fragment.MyWorkOrderFragment;
import com.example.generalframeworkmvp.fragment.SettingFragment;
import com.example.generalframeworkmvp.fragment.StockFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.bottom_ngs)
    BottomNavigationView bottom_ngs;

    private int index = 0;
    private String fragmentTag;
    private ArrayList<String> fragmentNames;
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        fragmentNames = new ArrayList<>();
        fragmentNames.add(HomeFragment.class.getName());
        fragmentNames.add(MyWorkOrderFragment.class.getName());
        fragmentNames.add(StockFragment.class.getName());
        fragmentNames.add(SettingFragment.class.getName());

        fragmentTag = fragmentNames.get(index);
        Fragment fragment = getFragmentByTag(fragmentTag);
        showFragment(mCurrentFragment, fragment, fragmentTag);

        initListener();
    }

    @Override
    public int getlayoutId() {
        return R.layout.activity_main;
    }

    private void initListener() {
        bottom_ngs.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.homeFragment) {
                    index = 0;
                } else if (menuItem.getItemId() == R.id.MyWorkOrderFragment) {
                    index = 1;
                } else if (menuItem.getItemId() == R.id.StockFragment) {
                    index = 2;
                } else if (menuItem.getItemId() == R.id.SettingFragment) {
                    index = 3;
                }
                fragmentTag = fragmentNames.get(index);
                Fragment fragment = getFragmentByTag(fragmentTag);
                showFragment(mCurrentFragment, fragment, fragmentTag);

                return true;
            }
        });
    }

    private Fragment getFragmentByTag(String name) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(name);
        if (fragment != null) {
            return fragment;
        } else {
            try {
                fragment = (Fragment) Class.forName(name).newInstance();
            } catch (Exception e) {
                // fragment = new HomeFragment();
            }
        }
        return fragment;
    }

    private void showFragment(Fragment from, Fragment to, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (from == null) {
            if (to.isAdded()) {
                transaction.show(to);
            } else {
                transaction.add(R.id.fragment_nrs, to, tag);
            }
        } else {
            if (to.isAdded()) {
                transaction.hide(from).show(to);
            } else {
                transaction.hide(from).add(R.id.fragment_nrs, to, tag);
            }
        }
        transaction.commitAllowingStateLoss();
        mCurrentFragment = to;
    }
}
