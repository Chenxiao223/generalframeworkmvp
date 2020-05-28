package com.example.generalframeworkmvp.model;

import com.example.generalframeworkmvp.bean.BaseObjectBean;
import com.example.generalframeworkmvp.bean.LoginBean;
import com.example.generalframeworkmvp.contract.MainContract;
import com.example.generalframeworkmvp.net.RetrofitClient;

import io.reactivex.Flowable;

public class MainModel implements MainContract.Modle {
    @Override
    public Flowable<BaseObjectBean<LoginBean>> login(String username, String password) {
        return RetrofitClient.getInstance().getApi().login(username, password);
    }
}
